package com.example.jasper.sdklab.v1.common.token;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class TokenEncoderFactory {

    private TokenEncoderFactory() {}

    @CheckResult
    public static AccessTokenEncoder createDefaultEncoder(@Nullable ServerConfiguration serverConfiguration) {
        if (serverConfiguration == null) {
            throw new IllegalArgumentException("Server configuration can not be null");
        }
        return new BasicAccessTokenEncoder(serverConfiguration);
    }
}
