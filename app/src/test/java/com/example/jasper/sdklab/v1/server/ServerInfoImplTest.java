package com.example.jasper.sdklab.v1.server;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ServerInfoImplTest {
    @Mock
    com.jaspersoft.android.sdk.client.oxm.server.ServerInfo legacyInfo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAdaptLegacyServerCode() {
        when(legacyInfo.getVersion()).thenReturn("5.5");
        ServerInfo serverInfo = new ServerInfoImpl(legacyInfo);
        assertThat(serverInfo.getServerCode(), is("5.5"));
    }

    @Test
    public void shouldAdaptLegacyServerEdition() {
        when(legacyInfo.getEdition()).thenReturn("PRO");
        ServerInfo serverInfo = new ServerInfoImpl(legacyInfo);
        assertThat(serverInfo.getServerEdition(), is("PRO"));
    }
}
