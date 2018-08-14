package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.practice.rev180814;
import org.opendaylight.yangtools.yang.binding.RpcService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import java.util.concurrent.Future;

/**
 * Interface for implementing the following YANG RPCs defined in module <b>practice</b>
 * <pre>
 * rpc greet {
 *     input {
 *         leaf lf-input {
 *             type string;
 *         }
 *     }
 *     
 *     output {
 *         leaf lf-output {
 *             type string;
 *         }
 *     }
 * }
 * </pre>
 *
 */
public interface PracticeService
    extends
    RpcService
{




    Future<RpcResult<GreetOutput>> greet(GreetInput input);

}

