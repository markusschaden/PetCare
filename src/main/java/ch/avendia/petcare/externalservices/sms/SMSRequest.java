package ch.avendia.petcare.externalservices.sms;

import ch.avendia.petcare.entities.TelephoneNumber;
import lombok.Data;

/**
 * Created by Markus on 21.05.2015.
 */
@Data
public class SMSRequest {

    private TelephoneNumber to;
    private String message;

}
