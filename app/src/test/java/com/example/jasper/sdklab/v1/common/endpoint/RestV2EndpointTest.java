package com.example.jasper.sdklab.v1.common.endpoint;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Tom Koptel
 * @since 2.1
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class RestV2EndpointTest {
    @Mock
    ServerConfiguration mServerConfiguration;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnInternalValue() {
        when(mServerConfiguration.getBaseUrl()).thenReturn("http://localhost");
        Endpoint endpoint = new RestV2Endpoint(mServerConfiguration);
        assertThat(endpoint.getValue(), is("http://localhost/rest_v2"));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldEnsureValidityOfServerConfig() {
        when(mServerConfiguration.getBaseUrl()).thenReturn("");
        String endpoint = new RestV2Endpoint(mServerConfiguration).getValue();
    }
}
