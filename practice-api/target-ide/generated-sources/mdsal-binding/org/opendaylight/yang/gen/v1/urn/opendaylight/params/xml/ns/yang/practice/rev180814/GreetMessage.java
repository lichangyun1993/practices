package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Notification;

/**
 * <p>This class represents the following YANG schema fragment defined in module <b>practice</b>
 * <pre>
 * notification greet-message {
 *     leaf message {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>practice/greet-message</i>
 * 
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetMessageBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetMessageBuilder
 *
 */
public interface GreetMessage
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.GreetMessage>,
    Notification
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:practice",
        "2018-08-14", "greet-message").intern();

    /**
     * @return <code>java.lang.String</code> <code>message</code>, or <code>null</code> if not present
     */
    java.lang.String getMessage();

}

