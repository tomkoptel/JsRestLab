package com.example.jasper.sdklab.v1.server;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.ParameterizedRobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Tom Koptel
 * @since 2.1
 */

@RunWith(ParameterizedRobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ServerExecutionConfigurationParamsTest {

    private final String mEmpty;

    @ParameterizedRobolectricTestRunner.Parameters(name = "Injected value = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, "Null"},
                {"", "Empty String"},
                {"  ", "Spaces"},
        });
    }

    public ServerExecutionConfigurationParamsTest(String injected, String message) {
        mEmpty = injected;
    }

    private ServerExecutionConfiguration configuration;

    @Before
    public void setup() {
        configuration = ServerExecutionConfiguration.newInstance();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptEmptyUrl() {
        configuration.withBaseUrl(mEmpty);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAcceptOnlyNetworkUrl() {
        configuration.withBaseUrl("invalid url");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptInvalidUserId() {
        configuration.withUserId(mEmpty);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptEmptyUserPassword() {
        configuration.withPassword(mEmpty);
    }

}
