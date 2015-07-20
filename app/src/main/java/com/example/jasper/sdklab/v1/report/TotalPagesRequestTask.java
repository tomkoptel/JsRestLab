package com.example.jasper.sdklab.v1.report;

import com.example.jasper.sdklab.v1.common.RestCall;

import rx.Observable;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class TotalPagesRequestTask implements RestCall<Integer> {
    public Integer asBlocking() {
        throw new UnsupportedOperationException();
    }

    public Observable<Integer> asAsync() {
        throw new UnsupportedOperationException();
    }
}
