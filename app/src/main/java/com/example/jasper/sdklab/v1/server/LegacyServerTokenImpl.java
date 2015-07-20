package com.example.jasper.sdklab.v1.server;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import org.springframework.http.HttpHeaders;

import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class LegacyServerTokenImpl implements ServerToken {
    private final HttpHeaders mHttpHeaders;
    private String mValue;

    @VisibleForTesting
    LegacyServerTokenImpl(@NonNull HttpHeaders httpHeaders) {
        mHttpHeaders = httpHeaders;
    }

    @NonNull
    @Override
    public String getValue() {
        if (mValue == null) {
            mValue = generateToken();
        }
        return mValue;
    }

    private String generateToken() {
        List<String> cookies = filterCookieHeaders(mHttpHeaders);
        StringBuilder stringBuilder = joinCookieHeaders(cookies);
        appendTimeZone(stringBuilder);
        return stringBuilder.toString();
    }

    @VisibleForTesting
    void appendTimeZone(StringBuilder stringBuilder) {
        TimeZone timeZone = TimeZone.getDefault();
        stringBuilder.append(";userTimezone=").append(timeZone.getID());
    }

    @VisibleForTesting
    StringBuilder joinCookieHeaders(List<String> cookies) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = cookies.iterator();
        while (iterator.hasNext()) {
            String cookie = iterator.next();
            stringBuilder.append(cookie);
            if (iterator.hasNext()) {
                stringBuilder.append(";");
            }
        }
        return stringBuilder;
    }

    @VisibleForTesting
    List<String> filterCookieHeaders(HttpHeaders headers) {
        return headers.get("Set-Cookie");
    }

}
