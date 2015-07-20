package com.example.jasper.sdklab.v1.server;

import android.support.annotation.NonNull;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class ServerInfoImpl implements ServerInfo {
    private final com.jaspersoft.android.sdk.client.oxm.server.ServerInfo mLegacyInfo;

    ServerInfoImpl(com.jaspersoft.android.sdk.client.oxm.server.ServerInfo legacyInfo) {
        mLegacyInfo = legacyInfo;
    }

    @NonNull
    @Override
    public String getServerCode() {
        return mLegacyInfo.getVersion();
    }

    @NonNull
    @Override
    public String getServerEdition() {
        return mLegacyInfo.getEdition();
    }
}
