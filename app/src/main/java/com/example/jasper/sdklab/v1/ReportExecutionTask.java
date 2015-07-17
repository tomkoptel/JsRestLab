package com.example.jasper.sdklab.v1;

import com.example.jasper.sdklab.v1.common.RestCall;

import rx.Observable;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class ReportExecutionTask implements RestCall<ReportClient> {
    public ReportClient asBlocking() {
        throw new UnsupportedOperationException();
    }

    public Observable<ReportClient> asAsync() {
        throw new UnsupportedOperationException();
    }
}
