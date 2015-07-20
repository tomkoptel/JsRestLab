package com.example.jasper.sdklab.v1.common.token;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class TokenEncoderFactoryTest {
    @Mock
    ServerConfiguration mServerConfiguration;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateDefaultImplementationForEncoder() {
        AccessTokenEncoder tokenEncoder =
                TokenEncoderFactory.createDefaultEncoder(mServerConfiguration);
        assertThat(tokenEncoder, is(notNullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNullServerConfiguration() {
        AccessTokenEncoder tokenEncoder =
                TokenEncoderFactory.createDefaultEncoder(null);
    }
}
