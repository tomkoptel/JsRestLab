package com.example.jasper.sdklab.v1;

import com.jaspersoft.android.sdk.client.oxm.report.ReportParameter;

import java.util.Collection;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class ReportExecutionConfiguration {
    private final Configuration configuration;

    public ReportExecutionConfiguration(Configuration configuration) {
        throw new UnsupportedOperationException();
    }

    public void addReportParameters(Collection<ReportParameter> params) {
        throw new UnsupportedOperationException();
    }

    public static ReportExecutionConfiguration asyncConfiguration(String reportUri) {
        throw new UnsupportedOperationException();
    }

    private enum Configuration {
        ASYNC, SYNC;
    }
}
