package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814;
import org.opendaylight.yangtools.yang.binding.NotificationListener;

/**
 * Interface for receiving the following YANG notifications defined in module <b>practice</b>
 * <pre>
 * notification greet-message {
 *     leaf message {
 *         type string;
 *     }
 * }
 * </pre>
 *
 */
public interface PracticeListener
    extends
    NotificationListener
{




    void onGreetMessage(GreetMessage notification);

}

