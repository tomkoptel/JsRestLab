package com.example.jasper.sdklab.v1.server;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ServerConfiguration {
    private String userId;
    private String organization;
    private String baseUrl;
    private String password;

    public static ServerConfiguration newInstance() {
        throw new UnsupportedOperationException();
    }

    public ServerConfiguration withBaseUrl(String baseUrl) {
        throw new UnsupportedOperationException();
    }

    public ServerConfiguration withUserId(String userId) {
        throw new UnsupportedOperationException();
    }

    public ServerConfiguration withOrganization(String organization) {
        throw new UnsupportedOperationException();
    }

    public ServerConfiguration withPassword(String password) {
        throw new UnsupportedOperationException();
    }

    public String getUserId() {
        return userId;
    }

    public String getOrganization() {
        return organization;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getPassword() {
        return password;
    }

    private void ensureSaneValue(String message, String value) {
        if (value == null) {
            throw new IllegalStateException(message);
        }
    }
}
