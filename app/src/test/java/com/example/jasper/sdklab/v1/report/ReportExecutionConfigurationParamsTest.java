package com.example.jasper.sdklab.v1.report;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.ParameterizedRobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tom Koptel
 * @since 2.1
 */
@RunWith(ParameterizedRobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ReportExecutionConfigurationParamsTest {
    private final String mEmpty;

    @ParameterizedRobolectricTestRunner.Parameters(name = "Injected value = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, "Null"},
                {"", "Empty String"},
                {"  ", "Spaces"},
                {"some_ur", "Invalid uri: some_ur"},
                {"/uri//1///", "Invalid uri: /uri//1///"},
        });
    }

    public ReportExecutionConfigurationParamsTest(String injected, String message) {
        mEmpty = injected;
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptInvalidUri() {
        ReportExecutionConfiguration.newInstance(mEmpty);
    }

    @Test
    public void shouldAllowAsyncConfiguration() {
        String validUri = "/my/report";
        ReportExecutionConfiguration configuration =
                ReportExecutionConfiguration.newInstance(validUri);
        assertThat(configuration.isAsync(), is(true));
    }
}
