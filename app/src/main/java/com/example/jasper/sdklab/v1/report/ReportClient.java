package com.example.jasper.sdklab.v1.report;

import com.example.jasper.sdklab.v1.common.RestCall;
import com.example.jasper.sdklab.v1.report.export.ExportPageRange;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public interface ReportClient {
    RestCall<ParcelFileExportResult> requestExport(ExportPageRange pageRange);
}
