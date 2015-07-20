package com.example.jasper.sdklab.v1.report;

import com.example.jasper.sdklab.v1.common.RestCall;

import rx.Observable;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class PageExportRequestTask implements RestCall<ParcelFileExportResult> {
    @Override
    public ParcelFileExportResult asBlocking() {
        return null;
    }

    @Override
    public Observable<ParcelFileExportResult> asAsync() {
        return null;
    }
}
