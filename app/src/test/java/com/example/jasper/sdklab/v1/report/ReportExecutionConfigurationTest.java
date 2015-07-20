package com.example.jasper.sdklab.v1.report;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tom Koptel
 * @since 2.1
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ReportExecutionConfigurationTest {
    private static final String VALID_URI = "/my/report";
    private ReportExecutionConfiguration configuration;

    @Before
    public void setup() {
        configuration = ReportExecutionConfiguration.newInstance(VALID_URI);
    }

    @Test
    public void shouldAllowAsyncConfiguration() {
        assertThat(configuration.isAsync(), is(true));
    }

    @Test
    public void shouldIgnoreNullReportParameters() {
        configuration.addReportParameters(null);
        assertThat(configuration.getReportParameters().size(), is(0));
    }

    @Test
    public void shouldHoldReportParameters() {
        Map<String, String> params = new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
        }};
        configuration.addReportParameters(params);

        Map<String, String> paramsUnderTest = configuration.getReportParameters();
        assertThat(paramsUnderTest.get("key1"), is("value1"));
        assertThat(paramsUnderTest.get("key2"), is("value2"));
    }
}
