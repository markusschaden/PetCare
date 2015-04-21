package ch.avendia.petcare.framework.security.session;

/**
 * Created by Markus on 20.04.2015.
 */
public class SessionIdentifierGeneratorTest {


    public static void main(String[] args) {

        SessionIdentifierGenerator sig = new SessionIdentifierGenerator();

        for(int i=0;i<10;i++)
        System.out.println(sig.createWord(64));

    }

}
