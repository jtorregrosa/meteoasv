package com.jtorregrosa.meteoasv.aemet.utils;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * This class trust all remote certificates for HTTPS calls.
 * <p>
 * THIS IS NOT SAFE AND MUST BE REFACTORED. IT'S JUST A WORKAROUND FOR CERTIFICATE ISSUES WITH AEMET SITE.
 */
public class TrustAllX509TrustManager implements X509TrustManager {

    /**
     * Given the partial or complete certificate chain provided by the peer, build a certificate path to a trusted root
     * and return if it can be validated and is trusted for client SSL authentication based on the authentication type.
     * The authentication type is determined by the actual certificate used. For instance, if RSAPublicKey is used, the
     * authType should be "RSA". Checking is case-sensitive.
     *
     * @param x509Certificates the peer certificate chain.
     * @param authType         the authentication type based on the client certificate.
     * @throws CertificateException if the certificate chain is not trusted by this TrustManager.
     */
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String authType) throws CertificateException {
        // Method intentionally left blank.
    }

    /**
     * Given the partial or complete certificate chain provided by the peer, build a certificate path to a trusted root
     * and return if it can be validated and is trusted for server SSL authentication based on the authentication type.
     * The authentication type is the key exchange algorithm portion of the cipher suites represented as a String, such
     * as "RSA", "DHE_DSS". Note: for some exportable cipher suites, the key exchange algorithm is determined at run
     * time during the handshake. For instance, for TLS_RSA_EXPORT_WITH_RC4_40_MD5, the authType should be RSA_EXPORT
     * when an ephemeral RSA key is used for the key exchange, and RSA when the key from the server certificate is used.
     * Checking is case-sensitive.
     *
     * @param x509Certificates the peer certificate chain.
     * @param authType         the authentication type based on the client certificate.
     * @throws CertificateException if the certificate chain is not trusted by this TrustManager.
     */
    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String authType) throws CertificateException {
        // Method intentionally left blank.
    }

    /**
     * Return an array of certificate authority certificates which are trusted for authenticating peers.
     *
     * @return a non-null (possibly empty) array of acceptable CA issuer certificates.
     */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
