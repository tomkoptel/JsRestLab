package com.example.jasper.sdklab.v1.common.endpoint;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class EndpointFactoryTest {
    @Mock
    ServerConfiguration mServerConfiguration;
    @Mock
    Endpoint mBaseEndpoint;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateRestV2Endpoint() {
        Endpoint endpoint = EndpointFactory.createRestV2Endpoint(mServerConfiguration);
        assertThat(endpoint, is(notNullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNullValueForRestV2Endpoint() {
        Endpoint endpoint = EndpointFactory.createRestV2Endpoint(null);
    }

    @Test
    public void shouldCreateResourcesEndpoint() {
        Endpoint endpoint = EndpointFactory.createResourcesEndpoint(mBaseEndpoint);
        assertThat(endpoint, is(notNullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNullValueForResourcesEndpoint() {
        Endpoint endpoint = EndpointFactory.createResourcesEndpoint(null);
    }
}
