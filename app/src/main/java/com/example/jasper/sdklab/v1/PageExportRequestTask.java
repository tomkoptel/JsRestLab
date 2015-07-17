package com.example.jasper.sdklab.v1;

import rx.Observable;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class PageExportRequestTask implements RestCall<ExportResult> {
    @Override
    public ExportResult asBlocking() {
        return null;
    }

    @Override
    public Observable<ExportResult> asAsync() {
        return null;
    }
}
