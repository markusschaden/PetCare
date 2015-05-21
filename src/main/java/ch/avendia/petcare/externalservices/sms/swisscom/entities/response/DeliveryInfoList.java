
package ch.avendia.petcare.externalservices.sms.swisscom.entities.response;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class DeliveryInfoList {

    @Expose
    private List<DeliveryInfo> deliveryInfo = new ArrayList<DeliveryInfo>();
    @Expose
    private String resourceURL;

    /**
     * 
     * @return
     *     The deliveryInfo
     */
    public List<DeliveryInfo> getDeliveryInfo() {
        return deliveryInfo;
    }

    /**
     * 
     * @param deliveryInfo
     *     The deliveryInfo
     */
    public void setDeliveryInfo(List<DeliveryInfo> deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
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
