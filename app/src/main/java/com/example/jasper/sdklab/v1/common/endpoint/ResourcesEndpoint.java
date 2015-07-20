package com.example.jasper.sdklab.v1.common.endpoint;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ResourcesEndpoint implements Endpoint {
    private final Endpoint mBaseEndpoint;

    @VisibleForTesting
    ResourcesEndpoint(@NonNull Endpoint baseEndpoint) {
        mBaseEndpoint = baseEndpoint;
    }

    @NonNull
    @Override
    public String getValue() {
        if (TextUtils.isEmpty(mBaseEndpoint.getValue())) {
            throw new IllegalStateException("Misconfigured base endpoint detected.");
        }
        return mBaseEndpoint.getValue() + "/resources";
    }
}
