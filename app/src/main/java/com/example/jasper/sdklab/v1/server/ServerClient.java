package com.example.jasper.sdklab.v1.server;

import android.support.annotation.WorkerThread;

import com.example.jasper.sdklab.v1.common.RestCallback;

import rx.Observable;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ServerClient {
    private final ServerConfiguration mServerConfiguration;

    public ServerClient(ServerConfiguration serverConfiguration) {
        throw new UnsupportedOperationException();
    }

    @WorkerThread
    public ServerConnection establishConnectionBlocking() {
        throw new UnsupportedOperationException();
    }

    public Observable<ServerConnection> establishConnection() {
        throw new UnsupportedOperationException();
    }

    public void establishConnection(RestCallback<ServerConnection> restCallback) {
        throw new UnsupportedOperationException();
    }
}
