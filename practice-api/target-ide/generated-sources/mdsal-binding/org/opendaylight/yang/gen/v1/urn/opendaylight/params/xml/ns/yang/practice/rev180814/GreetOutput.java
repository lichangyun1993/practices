package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;

/**
 * <p>This class represents the following YANG schema fragment defined in module <b>practice</b>
 * <pre>
 * container output {
 *     leaf lf-output {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>practice/greet/output</i>
 * 
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetOutputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetOutputBuilder
 *
 */
public interface GreetOutput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetOutput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:practice",
        "2018-08-14", "output").intern();

    /**
     * @return <code>java.lang.String</code> <code>lfOutput</code>, or <code>null</code> if not present
     */
    java.lang.String getLfOutput();

}

