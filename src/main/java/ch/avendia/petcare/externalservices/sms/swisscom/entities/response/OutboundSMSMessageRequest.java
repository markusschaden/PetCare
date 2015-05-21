
package ch.avendia.petcare.externalservices.sms.swisscom.entities.response;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class OutboundSMSMessageRequest {

    @Expose
    private List<String> address = new ArrayList<String>();
    @Expose
    private DeliveryInfoList deliveryInfoList;
    @Expose
    private String senderAddress;
    @Expose
    private OutboundSMSTextMessage outboundSMSTextMessage;
    @Expose
    private String clientCorrelator;
    @Expose
    private String senderName;
    @Expose
    private String resourceURL;

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
     *     The deliveryInfoList
     */
    public DeliveryInfoList getDeliveryInfoList() {
        return deliveryInfoList;
    }

    /**
     * 
     * @param deliveryInfoList
     *     The deliveryInfoList
     */
    public void setDeliveryInfoList(DeliveryInfoList deliveryInfoList) {
        this.deliveryInfoList = deliveryInfoList;
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

    /**
     * 
     * @return
     *     The clientCorrelator
     */
    public String getClientCorrelator() {
        return clientCorrelator;
    }

    /**
     * 
     * @param clientCorrelator
     *     The clientCorrelator
     */
    public void setClientCorrelator(String clientCorrelator) {
        this.clientCorrelator = clientCorrelator;
    }

    /**
     * 
     * @return
     *     The senderName
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * 
     * @param senderName
     *     The senderName
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     * 
     * @return
     *     The resourceURL
     */
    public String getResourceURL() {
        return resourceURL;
    }

    /**
     * 
     * @param resourceURL
     *     The resourceURL
     */
    public void setResourceURL(String resourceURL) {
        this.resourceURL = resourceURL;
    }

}
