package ch.avendia.petcare.externalservices.sms;

import ch.avendia.petcare.entities.Account;
import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.entities.TelephoneNumber;
import ch.avendia.petcare.framework.di.ModuleInjector;
import ch.avendia.petcare.framework.security.session.SessionIdentifierGenerator;
import ch.avendia.petcare.framework.security.session.SessionService;
import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Markus on 20.04.2015.
 */
public class SwisscomSMSGatewayTest {

    Injector injector;

    @Before
    public void setup() {
        injector = Guice.createInjector(new ModuleInjector());

    }


    @Test
    public void testSendSms() throws Exception {

        SMSGateway smsGateway = injector.getInstance(SMSGateway.class);

        TelephoneNumber telephoneNumber = new TelephoneNumber();
        telephoneNumber.setCountryCode("+41");
        telephoneNumber.setPhoneNumber("763387848");

        SMSRequest smsRequest = new SMSRequest();
        smsRequest.setMessage("Ch\u00E4\u00E4\u00E4s  ההה :)");
        smsRequest.setTo(telephoneNumber);

        smsGateway.sendSMS(smsRequest);

        //assertEquals(s, loadedSession);
    }


}
