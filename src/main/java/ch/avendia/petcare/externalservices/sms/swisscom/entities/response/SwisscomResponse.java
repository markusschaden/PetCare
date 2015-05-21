
package ch.avendia.petcare.externalservices.sms.swisscom.entities.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class SwisscomResponse {

    @Expose
    private OutboundSMSMessageRequest outboundSMSMessageRequest;

    /**
     * 
     * @return
     *     The outboundSMSMessageRequest
     */
    public OutboundSMSMessageRequest getOutboundSMSMessageRequest() {
        return outboundSMSMessageRequest;
    }

    /**
     * 
     * @param outboundSMSMessageRequest
     *     The outboundSMSMessageRequest
     */
    public void setOutboundSMSMessageRequest(OutboundSMSMessageRequest outboundSMSMessageRequest) {
        this.outboundSMSMessageRequest = outboundSMSMessageRequest;
    }

}
