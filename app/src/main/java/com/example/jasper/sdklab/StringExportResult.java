package com.example.jasper.sdklab;

import android.os.ParcelFileDescriptor;

import com.example.jasper.sdklab.v1.report.export.ExportResult;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class StringExportResult implements ExportResult<String> {
    public StringExportResult(ExportResult<ParcelFileDescriptor> exportResult) {

    }

    @Override
    public String getExport() {
        throw new UnsupportedOperationException();
    }
}
