package com.example.jasper.sdklab.v1;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * @author Tom Koptel
 * @since 2.1
 */
@RunWith(JUnitParamsRunner.class)
public class ServerConnectionConfigurationTest {

    private ServerConfiguration configuration;

    @Before
    public void setup() {
        configuration = ServerConfiguration.newInstance();
    }

    @Parameters(method = "getEmptyValues")
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptEmptyUrl(String empty) {
        configuration.withBaseUrl(empty);
    }

    @Parameters(method = "getEmptyValues")
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptInvalidUserId(String empty) {
        configuration.withUserId(empty);
    }

    @Parameters(method = "getEmptyValues")
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptEmptyUserPassword(String empty) {
        configuration.withPassword(empty);
    }

    public Object[] getEmptyValues() {
        return new Object[] {
                null, "", "  "
        };
    }
}
