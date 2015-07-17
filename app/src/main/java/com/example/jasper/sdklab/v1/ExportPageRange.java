package com.example.jasper.sdklab.v1;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ExportPageRange {
    private final int mStart;
    private final int mEnd;

    private ExportPageRange(int start, int end) {
        mStart = start;
        mEnd = end;
    }

    public static ExportPageRange createForRange(int start, int end) {
        throw new UnsupportedOperationException();
    }

    public static ExportPageRange createForSinglePage(int page) {
        throw new UnsupportedOperationException();
    }
}
