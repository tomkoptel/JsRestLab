package com.example.jasper.sdklab.v1.server;

import com.example.jasper.sdklab.v1.RestCall;

import rx.Observable;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ServerConnection {
    public static Request connect(String baseUrl) {
        throw new UnsupportedOperationException();
    }

    public static class Request implements RestCall<ServerConnection> {
        @Override
        public ServerConnection asBlocking() {
            return null;
        }

        @Override
        public Observable<ServerConnection> asAsync() {
            return null;
        }
    }
}
