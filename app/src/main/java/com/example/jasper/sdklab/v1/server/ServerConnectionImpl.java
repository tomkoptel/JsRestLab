package com.example.jasper.sdklab.v1.server;

import android.support.annotation.NonNull;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class ServerConnectionImpl implements ServerConnection {
    @NonNull
    @Override
    public ServerToken getToken() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public ServerInfo getInfo() {
        throw new UnsupportedOperationException();
    }
}
