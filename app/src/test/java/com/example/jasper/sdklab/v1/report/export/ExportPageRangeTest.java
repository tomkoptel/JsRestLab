package com.example.jasper.sdklab.v1.report.export;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ExportPageRangeTest {

    @Test
    public void shouldCreateInstanceForSinglePage() {
        ExportPageRange range = ExportPageRange.createForRange(1, 10);
        String rangeValue = range.getValue();
        assertThat(rangeValue, is("1-10"));
    }

    @Test
    public void shouldCreateInstanceForRange() {
        ExportPageRange range = ExportPageRange.createForSinglePage(1);
        String rangeValue = range.getValue();
        assertThat(rangeValue, is("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNegativeValueForStartPage() {
        ExportPageRange.createForRange(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNegativeValueForEndPage() {
        ExportPageRange.createForRange(1, -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptZeroValueForStart() {
        ExportPageRange.createForRange(0, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptZeroValueForEnd() {
        ExportPageRange.createForRange(10, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromPageShouldBeLowerOrEqualToHigherValue() {
        ExportPageRange.createForRange(10, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNegativeValueForSinglePage() {
        ExportPageRange.createForSinglePage(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptZeroValueForSinglePage() {
        ExportPageRange.createForSinglePage(0);
    }
}
