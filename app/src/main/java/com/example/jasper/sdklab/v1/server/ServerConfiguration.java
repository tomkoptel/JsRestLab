package com.example.jasper.sdklab.v1.server;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public interface ServerConfiguration {
    @NonNull
    String getBaseUrl();
    @NonNull
    String getUserId();
    @Nullable
    String getOrganization();
    @NonNull
    String getPassword();
}
