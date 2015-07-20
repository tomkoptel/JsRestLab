package com.example.jasper.sdklab.v1.server;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.FakeHttp;
import org.robolectric.tester.org.apache.http.FakeHttpLayer;
import org.robolectric.tester.org.apache.http.RequestMatcher;
import org.robolectric.tester.org.apache.http.TestHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Tom Koptel
 * @since 2.1
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class LegacyServerRestCommunicatorTest {

    @Mock
    ServerConfiguration mServerConfiguration;
    @Mock
    RestTemplate mRestTemplate;

    private MockWebServer mockWebServer;
    private String mBaseUrl;

    @Before
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);
        FakeHttp.getFakeHttpLayer().interceptHttpRequests(false);
        mockWebServer = new MockWebServer();
        mockWebServer.play();
        mBaseUrl = "http://localhost:" + mockWebServer.getPort();
    }

    @After
    public void teardown() throws IOException {
        mockWebServer.shutdown();
        FakeHttp.getFakeHttpLayer().interceptHttpRequests(true);
    }

    @Ignore
    @Test
    public void shouldRequestServerInfo() {
    }

    @Ignore
    @Test
    public void shouldRequestServerToken() throws IOException {
        when(mServerConfiguration.getBaseUrl()).thenReturn(mBaseUrl);

        MockResponse mockResponse = new MockResponse();
        mockResponse.addHeader("Set-Cookie", "cookie1");
        mockResponse.addHeader("Set-Cookie", "cookie2");
        mockResponse.setResponseCode(200);
        mockWebServer.enqueue(mockResponse);

        ServerRestCommunicator restCommunicator = LegacyServerRestCommunicator.newInstance(mServerConfiguration);
        ServerToken serverToken = restCommunicator.getServerToken();

        assertThat(serverToken, is(notNullValue()));
        String token = serverToken.getValue();
        assertThat(token, containsString("cookie1"));
        assertThat(token, containsString("cookie2"));
    }

    @Ignore
    @Test
    public void shouldRequestServerToken2() {
        when(mServerConfiguration.getBaseUrl()).thenReturn("http://localhost");

        FakeHttpLayer layer = FakeHttp.getFakeHttpLayer();

        HttpResponse response = new TestHttpResponse();
        response.setHeaders(new Header[]{
                new BasicHeader("Set-Cookie", "cookie1"),
                new BasicHeader("Set-Cookie", "cookie2"),
        });
        layer.addHttpResponseRule(new RequestMatcher() {
            @Override
            public boolean matches(HttpRequest request) {
                return request.getRequestLine().getUri().equals("http://localhost/rest_v2/resources");
            }
        }, response);

        ServerRestCommunicator restCommunicator = LegacyServerRestCommunicator.newInstance(mServerConfiguration);
        ServerToken serverToken = restCommunicator.getServerToken();

        assertThat(serverToken, is(notNullValue()));
        String token = serverToken.getValue();
        assertThat(token, containsString("cookie1"));
        assertThat(token, containsString("cookie2"));
    }

}
