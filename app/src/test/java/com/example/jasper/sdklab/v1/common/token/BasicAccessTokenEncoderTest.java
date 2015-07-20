package com.example.jasper.sdklab.v1.common.token;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Tom Koptel
 * @since 2.1
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class BasicAccessTokenEncoderTest {
    @Mock
    ServerConfiguration mServerConfiguration;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(mServerConfiguration.getUserId()).thenReturn("userId");
        when(mServerConfiguration.getPassword()).thenReturn("password");
        when(mServerConfiguration.getOrganization()).thenReturn("");
    }

    @Test
    public void shouldProvideBasicAuthForExistingOrganization() {
        when(mServerConfiguration.getOrganization()).thenReturn("organization");
        AccessTokenEncoder accessTokenEncoder = new BasicAccessTokenEncoder(mServerConfiguration);
        assertThat(accessTokenEncoder.encodeToken(), is("Basic dXNlcklkfG9yZ2FuaXphdGlvbjpwYXNzd29yZA=="));
    }

    @Test
    public void shouldProvideBasicAuthForMissingOrganization() {
        when(mServerConfiguration.getOrganization()).thenReturn("");
        AccessTokenEncoder accessTokenEncoder = new BasicAccessTokenEncoder(mServerConfiguration);
        assertThat(accessTokenEncoder.encodeToken(), is("Basic dXNlcklkOnBhc3N3b3Jk"));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateIfUserIdIsMissing() {
        when(mServerConfiguration.getUserId()).thenReturn("");
        AccessTokenEncoder accessTokenEncoder = new BasicAccessTokenEncoder(mServerConfiguration);
        accessTokenEncoder.encodeToken();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateIfPasswordIsMissing() {
        when(mServerConfiguration.getPassword()).thenReturn("");
        AccessTokenEncoder accessTokenEncoder = new BasicAccessTokenEncoder(mServerConfiguration);
        accessTokenEncoder.encodeToken();
    }
}
