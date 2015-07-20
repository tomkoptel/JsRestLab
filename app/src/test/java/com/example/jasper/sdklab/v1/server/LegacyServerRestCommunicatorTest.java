package com.example.jasper.sdklab.v1.server;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class LegacyServerRestCommunicatorTest {

    @Mock
    ServerConfiguration mServerConfiguration;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldRequestServerInfo() {
        ServerRestCommunicator communicator = new LegacyServerRestCommunicator(mServerConfiguration);
        ServerInfo serverInfo = communicator.getServerInfo();

        assertThat(serverInfo, is(notNullValue()));
        verify(mServerConfiguration, times(1)).getBaseUrl();
    }

    @Test
    public void shouldRequestServerToken() {
        ServerRestCommunicator communicator = new LegacyServerRestCommunicator(mServerConfiguration);
        ServerToken serverToken = communicator.getServerToken();

        assertThat(serverToken, is(notNullValue()));
        verify(mServerConfiguration, times(1)).getBaseUrl();
    }
}
