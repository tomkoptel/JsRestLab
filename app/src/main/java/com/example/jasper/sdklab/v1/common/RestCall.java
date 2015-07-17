package com.example.jasper.sdklab.v1.common;

import rx.Observable;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public interface RestCall<RESULT> {
    RESULT asBlocking();
    Observable<RESULT> asAsync();
}
