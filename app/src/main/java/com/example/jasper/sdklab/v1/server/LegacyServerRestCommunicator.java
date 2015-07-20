package com.example.jasper.sdklab.v1.server;

import android.support.annotation.NonNull;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class LegacyServerRestCommunicator implements ServerRestCommunicator {
    private final ServerConfiguration mServerConfiguration;

    LegacyServerRestCommunicator(ServerConfiguration serverConfiguration) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public ServerToken getServerToken() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public ServerInfo getServerInfo() {
        throw new UnsupportedOperationException();
    }
}
