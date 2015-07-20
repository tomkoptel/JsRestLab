package com.example.jasper.sdklab.v1.report;

import android.os.ParcelFileDescriptor;

import com.example.jasper.sdklab.v1.report.export.ExportResult;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ParcelFileExportResult implements ExportResult<ParcelFileDescriptor> {
    public ParcelFileDescriptor getExport() {
        throw new RuntimeException();
    }
}
