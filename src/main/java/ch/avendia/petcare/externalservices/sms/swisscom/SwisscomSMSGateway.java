package ch.avendia.petcare.externalservices.sms.swisscom;

import ch.avendia.petcare.externalservices.sms.SMSGateway;
import ch.avendia.petcare.externalservices.sms.SMSRequest;
import ch.avendia.petcare.externalservices.sms.SMSResponse;
import ch.avendia.petcare.externalservices.sms.swisscom.entities.request.OutboundSMSMessageRequest;
import ch.avendia.petcare.externalservices.sms.swisscom.entities.request.OutboundSMSTextMessage;
import ch.avendia.petcare.externalservices.sms.swisscom.entities.request.SwisscomRequest;
import ch.avendia.petcare.externalservices.sms.swisscom.entities.response.SwisscomResponse;
import ch.avendia.petcare.framework.logging.InjectLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Markus on 21.05.2015.
 */
public class SwisscomSMSGateway implements SMSGateway {

    private final String JSON = "application/json";

    private final String apiKey = "HqClg0dog7hmuax3Nf6I8B14kU3wyZS2";
    //private final String apiKey = "vU9WEcwYBldcL9BTyNAHUi4Kvi1whD9Q";
    private final String apiSecret = "z1PzrxCV2rGdpbR4";
    //private final String from = "+41791544781";
    private final String from = "+41763387848";

    @InjectLogger
    private Logger logger;

    private boolean debug = true;
    private HttpClient client;

    public SwisscomSMSGateway() {
        client = HttpClientBuilder.create().build();

        if(debug) {
            try {
                //no cert validation
                SSLContextBuilder builder = new SSLContextBuilder();
                builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                        builder.build());
                client = HttpClients.custom().setSSLSocketFactory(
                        sslsf).build();
                logger.debug("Using HttpClient with no Certificate validation");
            } catch(Exception e) {
                logger.warn("Could not create HTTPClient with no Certificate validation");
            }
        }
    }

    public SMSResponse sendSMS(SMSRequest smsRequest) throws ClientProtocolException, IOException {

        Gson gson = new Gson();

        String to = smsRequest.getTo().getCountryCode() + smsRequest.getTo().getPhoneNumber();
        String fromEncoded = URLEncoder.encode(from, "UTF-8");

        HttpPost post = new HttpPost(
                "https://api.swisscom.com/v1/messaging/sms/outbound/tel%3A" +
                        fromEncoded +
                        "/requests");

        if(debug) {
            HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
            logger.debug("Using proxy: " + proxy.getHostName() + ":" + proxy.getPort());
            RequestConfig config = RequestConfig.custom()
                    .setProxy(proxy)
                    .build();

            post.setConfig(config);
        }


        post.setHeader("client_id", apiKey);
        post.setHeader("Content-Type", JSON+"; charset=utf-8");

        OutboundSMSTextMessage outboundSMSTextMessage = new OutboundSMSTextMessage();
        outboundSMSTextMessage.setMessage(smsRequest.getMessage());

        OutboundSMSMessageRequest outboundSMSMessageRequest = new OutboundSMSMessageRequest();
        outboundSMSMessageRequest.setSenderAddress(from);
        outboundSMSMessageRequest.setAddress(Arrays.asList(new String[]{"tel:" + to}));
        outboundSMSMessageRequest.setOutboundSMSTextMessage(outboundSMSTextMessage);

        SwisscomRequest request = new SwisscomRequest();
        request.setOutboundSMSMessageRequest(outboundSMSMessageRequest);

        String payload = gson.toJson(request);
        //String payload = "{\"outboundSMSMessageRequest\":{\"address\":[\"tel:+41763387848\"],\"senderAddress\":\"+41763387848\",\"outboundSMSTextMessage\":{\"message\":\"Hallo Werner\\r\\nHoffe du chasch de Ch‰‰‰s ohni problem lese :)\"}}}";
        logger.debug("Request:" + payload);

        post.setEntity(new StringEntity(payload, ContentType.create(JSON)));

        if(true) {

            String tets = gson.toJson(smsRequest);

            System.out.println(tets);
            //throw new IOException();
        }

        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        logger.debug("Response:" + sb.toString());

        SwisscomResponse swisscomResponse = gson.fromJson(sb.toString(), SwisscomResponse.class);

        if(swisscomResponse == null || swisscomResponse.getOutboundSMSMessageRequest() == null) {
            logger.error("Can't send sms");
        }

        return null;
    }
}
