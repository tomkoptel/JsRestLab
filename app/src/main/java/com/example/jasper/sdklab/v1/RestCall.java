package com.example.jasper.sdklab.v1;

import rx.Observable;

/**
 * @author Tom Koptel
 * @since 2.1
 */
interface RestCall<RESULT> {
    RESULT asBlocking();
    Observable<RESULT> asAsync();
}
