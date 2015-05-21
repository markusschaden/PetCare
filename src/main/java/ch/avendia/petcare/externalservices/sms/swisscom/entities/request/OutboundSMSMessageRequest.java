
package ch.avendia.petcare.externalservices.sms.swisscom.entities.request;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class OutboundSMSMessageRequest {

    @Expose
    private List<String> address = new ArrayList<String>();
    @Expose
    private String senderAddress;
    @Expose
    private OutboundSMSTextMessage outboundSMSTextMessage;

    /**
     * 
     * @return
     *     The address
     */
    public List<String> getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(List<String> address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The senderAddress
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     * 
     * @param senderAddress
     *     The senderAddress
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    /**
     * 
     * @return
     *     The outboundSMSTextMessage
     */
    public OutboundSMSTextMessage getOutboundSMSTextMessage() {
        return outboundSMSTextMessage;
    }

    /**
     * 
     * @param outboundSMSTextMessage
     *     The outboundSMSTextMessage
     */
    public void setOutboundSMSTextMessage(OutboundSMSTextMessage outboundSMSTextMessage) {
        this.outboundSMSTextMessage = outboundSMSTextMessage;
    }

}
