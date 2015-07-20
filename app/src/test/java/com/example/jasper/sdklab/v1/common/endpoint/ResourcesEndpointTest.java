package com.example.jasper.sdklab.v1.common.endpoint;

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
public class ResourcesEndpointTest {
    @Mock
    Endpoint mBaseEndpoint;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnInternalValue() {
        when(mBaseEndpoint.getValue()).thenReturn("http://localhost");
        Endpoint endpoint = new ResourcesEndpoint(mBaseEndpoint);
        assertThat(endpoint.getValue(), is("http://localhost/resources"));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldEnsureValidityOfServerConfig() {
        when(mBaseEndpoint.getValue()).thenReturn("");
        String endpoint = new ResourcesEndpoint(mBaseEndpoint).getValue();
    }
}
