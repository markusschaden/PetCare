package ch.avendia.petcare.externalservices.sms;

/**
 * Created by Markus on 21.05.2015.
 */
public interface SMSGateway {

    SMSResponse sendSMS(SMSRequest smsRequest) throws Exception;

}
