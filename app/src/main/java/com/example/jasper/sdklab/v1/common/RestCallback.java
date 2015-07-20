package com.example.jasper.sdklab.v1.common;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public interface RestCallback<RESULT> {
    void onSuccess(RESULT result);
    void onError(Throwable throwable);
}
