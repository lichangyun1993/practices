package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;

/**
 * <p>This class represents the following YANG schema fragment defined in module <b>practice</b>
 * <pre>
 * container data-model {
 *     leaf name {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>practice/data-model</i>
 * 
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.DataModelBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.DataModelBuilder
 *
 */
public interface DataModel
    extends
    ChildOf<PracticeData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.DataModel>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:practice",
        "2018-08-14", "data-model").intern();

    /**
     * @return <code>java.lang.String</code> <code>name</code>, or <code>null</code> if not present
     */
    java.lang.String getName();

}

