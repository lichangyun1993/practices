/*
 * Copyright (c) 2018 UTStarcom, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package com.utstar.practice;


import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.PracticeService;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.PracticeListener;

public class PracticeConsumer implements PracticeListener {
    private static final Logger LOG = LoggerFactory.getLogger(PracticeConsumer.class);
    private PracticeService practiceService;

    public PracticeConsumer(final PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @Override
    public void onGreetMessage(GreetMessage notification) {
        LOG.info("greetMessage:" + notification.getMessage());
    }

}
