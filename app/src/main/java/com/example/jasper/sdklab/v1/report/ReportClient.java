package com.example.jasper.sdklab.v1.report;

import com.example.jasper.sdklab.v1.common.RestCall;
import com.example.jasper.sdklab.v1.report.export.ExportPageRange;
import com.example.jasper.sdklab.v1.server.ServerConfiguration;
import com.example.jasper.sdklab.v1.server.ServerConnection;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ReportClient {
    public TotalPagesRequestTask requestTotalPages() {
        throw new UnsupportedOperationException();
    }

    public RestCall<ParcelFileExportResult> requestExport(ExportPageRange pageRange) {
        throw new UnsupportedOperationException();
    }

    public static ReportClient create(ServerConfiguration serverConfiguration, ReportExecutionConfiguration reportConfiguration) {
        throw new UnsupportedOperationException();
    }

    public static ReportClient create(ServerConnection serverConnection, ReportExecutionConfiguration reportConfiguration) {
        throw new UnsupportedOperationException();
    }

}
