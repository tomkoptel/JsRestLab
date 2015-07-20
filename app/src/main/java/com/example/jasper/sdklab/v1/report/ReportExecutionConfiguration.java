package com.example.jasper.sdklab.v1.report;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ReportExecutionConfiguration {
    private final Map<String, String> mReportParameters;
    private final ExecutionMode mExecutionMode;
    private final String mUri;

    private ReportExecutionConfiguration(ExecutionMode mode, String uri) {
        mReportParameters = new HashMap<String, String>();
        mExecutionMode = mode;
        mUri = uri;
    }

    public static ReportExecutionConfiguration newInstance(@NonNull String reportUri) {
        if (TextUtils.isEmpty(reportUri)) {
            throw new IllegalArgumentException("Uri should not be empty or null. But was: " + reportUri);
        } else if (TextUtils.isEmpty(reportUri.trim())) {
            throw new IllegalArgumentException("After trim uri should not be empty.");
        }
        return new ReportExecutionConfiguration(ExecutionMode.ASYNC, reportUri);
    }

    public void addReportParameters(@Nullable Map<String, String> params) {
        if (params == null) {
            return;
        }
        mReportParameters.putAll(params);
    }

    public boolean isAsync() {
        return mExecutionMode == ExecutionMode.ASYNC;
    }

    @NonNull
    public String getUri() {
        return mUri;
    }

    @NonNull
    public Map<String, String> getReportParameters() {
        return mReportParameters;
    }

    private enum ExecutionMode {
        ASYNC, SYNC;
    }
}
