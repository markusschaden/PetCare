package ch.avendia.petcare.framework.security.session;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Markus on 20.04.2015.
 */
public final class SessionIdentifierGenerator {

    private SecureRandom secureRandom;

    public SessionIdentifierGenerator() {
        try {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException nsae) {

            }
            if (secureRandom == null) {
                //TODO: crash application

            }
            secureRandom.setSeed(System.currentTimeMillis());
        } catch (Exception e) {
            // log.fatal("error initializing secure random", e);
        }
    }

    /**
     * Generates a secure random word with the given length consisting of
     * uppercase and lowercase letters and numbers.
     *
     * @param len Amount of random characters to generate
     * @return random Word containing letters and numbers.
     */
    public String createWord(int len) {
        return createWord(len, null);
    }

    /**
     * Generates a secure random word with the given length.
     *
     * @param len      Amount of random characters to generate
     * @param alphabet Alphabet to generate from.
     * @return random Word containing letters and numbers.
     */
    public String createWord(int len, char[] alphabet) {

        if (alphabet == null) {
            alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"
                    .toCharArray();
        }

        StringBuffer out = new StringBuffer(len);
        for (int i = 0; i < len; i++) {
            out.append(alphabet[secureRandom.nextInt(alphabet.length)]);
        }

        return out.toString();
    }
}
