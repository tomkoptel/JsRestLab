package com.example.jasper.sdklab.v1.server;

import android.support.annotation.NonNull;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public interface ServerInfo {
    @NonNull
    String getServerCode();
    @NonNull
    String getServerEdition();
}
