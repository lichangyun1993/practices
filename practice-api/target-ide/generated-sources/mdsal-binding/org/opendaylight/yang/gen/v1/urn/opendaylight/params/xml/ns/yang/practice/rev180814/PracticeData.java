package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814;
import org.opendaylight.yangtools.yang.binding.DataRoot;

/**
 * <p>This class represents the following YANG schema fragment defined in module <b>practice</b>
 * <pre>
 * module practice {
 *     yang-version 1;
 *     namespace "urn:opendaylight:params:xml:ns:yang:practice";
 *     prefix "practice";
 * 
 *     revision 2018-08-14 {
 *         description "";
 *     }
 * 
 *     container data-model {
 *         leaf name {
 *             type string;
 *         }
 *     }
 * 
 *     notification greet-message {
 *         leaf message {
 *             type string;
 *         }
 *     }
 * 
 *     rpc greet {
 *         input {
 *             leaf lf-input {
 *                 type string;
 *             }
 *         }
 *         
 *         output {
 *             leaf lf-output {
 *                 type string;
 *             }
 *         }
 *     }
 * }
 * </pre>
 *
 */
public interface PracticeData
    extends
    DataRoot
{




    /**
     * @return <code>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814.DataModel</code> <code>dataModel</code>, or <code>null</code> if not present
     */
    DataModel getDataModel();

}

