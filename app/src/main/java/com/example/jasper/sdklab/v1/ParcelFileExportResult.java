package com.example.jasper.sdklab.v1;

import android.os.ParcelFileDescriptor;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ParcelFileExportResult implements ExportResult<ParcelFileDescriptor> {
    public ParcelFileDescriptor getExport() {
        throw new RuntimeException();
    }
}
