package com.example.jasper.sdklab.v1.report.export;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ExportPageRange {
    private final long mStart;
    private final long mEnd;

    private ExportPageRange(long page) {
        this(page, page);
    }

    private ExportPageRange(long start, long end) {
        if (start < 0) {
            throw new IllegalArgumentException("Start value could not be negative");
        }
        if (end < 0) {
            throw new IllegalArgumentException("End value could not be negative");
        }
        if (start == 0) {
            throw new IllegalArgumentException("Start value should not be zero");
        }
        if (end == 0) {
            throw new IllegalArgumentException("End value should not be zero");
        }
        if (end < start) {
            throw new IllegalArgumentException("Start should be lower than end. " + this);
        }
        mStart = start;
        mEnd = end;
    }

    @IntRange(from = 1)
    public static ExportPageRange createForRange(long start, long end) {
        return new ExportPageRange(start, end);
    }

    public static ExportPageRange createForSinglePage(long page) {
        return new ExportPageRange(page);
    }

    @NonNull
    public String getValue() {
        if (mStart == mEnd) {
            return String.valueOf(mStart);
        }
        return String.format("%d-%d", mStart, mEnd);
    }

    @Override
    public String toString() {
        return "ExportPageRange{" +
                "mStart=" + mStart +
                ", mEnd=" + mEnd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExportPageRange range = (ExportPageRange) o;

        if (mStart != range.mStart) return false;
        return mEnd == range.mEnd;

    }

    @Override
    public int hashCode() {
        int result = (int) (mStart ^ (mStart >>> 32));
        result = 31 * result + (int) (mEnd ^ (mEnd >>> 32));
        return result;
    }
}
