package com.example.jasper.sdklab.v1;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;
import com.example.jasper.sdklab.v1.server.ServerConnection;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class ReportExecutionSession {
    public ReportExecutionTask requestReportClient() {
        throw new UnsupportedOperationException();
    }

    public static ReportExecutionSession createSession(
            ServerConnection serverConnection, ReportExecutionConfiguration configuration) {
        throw new UnsupportedOperationException();
    }

    public static ReportExecutionSession createSession(
            ServerConfiguration serverConfiguration, ReportExecutionConfiguration configuration) {
        throw new UnsupportedOperationException();
    }
}
