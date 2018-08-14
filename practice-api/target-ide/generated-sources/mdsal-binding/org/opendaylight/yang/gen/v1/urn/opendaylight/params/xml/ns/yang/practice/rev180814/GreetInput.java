package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;

/**
 * <p>This class represents the following YANG schema fragment defined in module <b>practice</b>
 * <pre>
 * container input {
 *     leaf lf-input {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>practice/greet/input</i>
 * 
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetInputBuilder
 *
 */
public interface GreetInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:practice",
        "2018-08-14", "input").intern();

    /**
     * @return <code>java.lang.String</code> <code>lfInput</code>, or <code>null</code> if not present
     */
    java.lang.String getLfInput();

}

