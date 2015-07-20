package com.example.jasper.sdklab.v1.report;

import com.example.jasper.sdklab.v1.common.RestCall;
import com.example.jasper.sdklab.v1.server.ServerConfiguration;
import com.example.jasper.sdklab.v1.server.ServerConnection;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ReportExecutionSession {
    private final ServerConfiguration mServerConfiguration;
    private final ReportExecutionConfiguration mReportExecutionConfiguration;

    public ReportExecutionSession(ServerConfiguration serverConfiguration, ReportExecutionConfiguration reportExecutionConfiguration) {
        mServerConfiguration = serverConfiguration;
        mReportExecutionConfiguration = reportExecutionConfiguration;
    }

    public RestCall<ReportClient> requestReportClient() {
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

    public void start() {

    }
}
