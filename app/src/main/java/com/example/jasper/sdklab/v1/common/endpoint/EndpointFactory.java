package com.example.jasper.sdklab.v1.common.endpoint;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class EndpointFactory {
    private EndpointFactory() {}

    @NonNull
    @CheckResult
    public static Endpoint createRestV2Endpoint(@Nullable ServerConfiguration serverConfiguration) {
        if (serverConfiguration == null) {
            throw new IllegalArgumentException("Configuration should not be null");
        }
        return new RestV2Endpoint(serverConfiguration);
    }

    @NonNull
    @CheckResult
    public static Endpoint createResourcesEndpoint(@Nullable Endpoint baseEndpoint) {
        if (baseEndpoint == null) {
            throw new IllegalArgumentException("Base endpoint should not be null");
        }
        return new ResourcesEndpoint(baseEndpoint);
    }
}
