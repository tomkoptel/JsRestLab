package com.example.jasper.sdklab.v1.common.endpoint;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class RestV2Endpoint implements Endpoint {
    private final ServerConfiguration mServerConfiguration;

    @VisibleForTesting
    RestV2Endpoint(@NonNull ServerConfiguration serverConfiguration) {
        mServerConfiguration = serverConfiguration;
    }

    @NonNull
    @Override
    public String getValue() {
        if (TextUtils.isEmpty(mServerConfiguration.getBaseUrl())) {
            throw new IllegalStateException("Server configuration has empty baseUrl.");
        }
        return mServerConfiguration.getBaseUrl() + "/rest_v2";
    }
}
