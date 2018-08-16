/*
 * Copyright (c) 2018 UTStarcom, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package com.utstar.practice;

import org.opendaylight.yangtools.concepts.ListenerRegistration;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetMessageBuilder;
import org.opendaylight.controller.md.sal.binding.api.DataObjectModification;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.DataModelBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetOutputBuilder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.opendaylight.controller.md.sal.binding.api.DataTreeIdentifier;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.NotificationPublishService;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.DataModel;
import java.util.Collection;
import java.util.concurrent.Future;
import org.opendaylight.controller.md.sal.binding.api.DataTreeModification;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetOutput;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.controller.md.sal.binding.api.DataTreeChangeListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.PracticeService;

public class PracticeProvider implements PracticeService, DataTreeChangeListener<DataModel>, AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(PracticeProvider.class);
    private static final InstanceIdentifier<DataModel> DATAMODDULE_IID = InstanceIdentifier.builder(DataModel.class)
        .build();

    private final DataBroker dataBroker;
    private NotificationPublishService notificationPublishService;
    private ListenerRegistration<PracticeProvider> registerDataTreeChangeListener;

    public PracticeProvider(final DataBroker dataBroker, final NotificationPublishService notificationPublishService) {
        this.dataBroker = dataBroker;
        this.notificationPublishService = notificationPublishService;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("PracticeProvider Session Initiated");
        // 向dataStore注册监听
        DataTreeIdentifier<DataModel> dataTreeIdentifier =
            new DataTreeIdentifier<>(LogicalDatastoreType.CONFIGURATION, DATAMODDULE_IID);
        registerDataTreeChangeListener = dataBroker.registerDataTreeChangeListener(dataTreeIdentifier, this);
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    @Override
    public void close() {
        LOG.info("PracticeProvider Closed");
        if (registerDataTreeChangeListener != null) {
            registerDataTreeChangeListener.close();
        }

    }

    @Override
    public Future<RpcResult<GreetOutput>> greet(GreetInput input) {
        GreetOutputBuilder greetOutputBuilder = new GreetOutputBuilder();
        greetOutputBuilder.setLfOutput(input.getLfInput());
        // 将数据写入dataStore
        LOG.info("Put the DataModel operational data into the MD-SAL data store");
        DataModelBuilder dataModelBuilder = new DataModelBuilder().setName(input.getLfInput());
        ReadWriteTransaction wt = dataBroker.newReadWriteTransaction();
        wt.put(LogicalDatastoreType.CONFIGURATION, DATAMODDULE_IID, dataModelBuilder.build());
        Futures.addCallback(wt.submit(), new FutureCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                LOG.info("Put the DataModel operational data into the MD-SAL data store success");
            }

            @Override
            public void onFailure(Throwable hrowable) {
                LOG.error("Put the DataModel operational data into the MD-SAL data store faile");
            }

        });

        return RpcResultBuilder.success(greetOutputBuilder.build()).buildFuture();
    }

    @Override
    public void onDataTreeChanged(Collection<DataTreeModification<DataModel>> changes) {
        for (DataTreeModification<DataModel> change : changes) {
            DataObjectModification<DataModel> rootNode = change.getRootNode();
            switch (rootNode.getModificationType()) {
                case WRITE:
                    LOG.info("Write - before : {} after : {} ", rootNode.getDataBefore(), rootNode.getDataAfter());
                    // 将数据变化转换为通知发布
                    try {
                        GreetMessageBuilder gmb =
                            new GreetMessageBuilder().setMessage(rootNode.getDataAfter().getName());
                        notificationPublishService.putNotification(gmb.build());
                    } catch (InterruptedException e) {
                        LOG.error("WRITE:Convert data changes to notification publish error;"
                            + rootNode.getDataAfter().getName());
                    }
                    break;
                case SUBTREE_MODIFIED:
                    LOG.info("Subtree_modified - before : {} after : {}", rootNode.getDataBefore(),
                        rootNode.getDataAfter());
                    // 将数据变化转换为通知发布
                    try {
                        GreetMessageBuilder gmb =
                            new GreetMessageBuilder().setMessage(rootNode.getDataAfter().getName());
                        notificationPublishService.putNotification(gmb.build());
                    } catch (InterruptedException e) {
                        LOG.error("SUBTREE_MODIFIED:Convert data changes to notification publish error"
                            + rootNode.getDataAfter().getName());
                    }
                    break;
                case DELETE:
                    LOG.info("Delete - before : {} after : {}", rootNode.getDataBefore());
                    // 将数据变化转换为通知发布
                    try {
                        GreetMessageBuilder gmb =
                            new GreetMessageBuilder().setMessage(rootNode.getDataBefore().getName());
                        notificationPublishService.putNotification(gmb.build());
                    } catch (InterruptedException e) {
                        LOG.error("DELETE:Convert data changes to notification publish error"
                            + rootNode.getDataAfter().getName());
                    }
                    break;
            }
        }

    }



}
