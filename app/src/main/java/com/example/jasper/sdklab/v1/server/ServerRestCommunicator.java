package com.example.jasper.sdklab.v1.server;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

/**
 * @author Tom Koptel
 * @since 2.1
 */
interface ServerRestCommunicator {
    @CheckResult
    @NonNull
    ServerToken getServerToken();
    @CheckResult
    @NonNull
    ServerInfo getServerInfo();
}
