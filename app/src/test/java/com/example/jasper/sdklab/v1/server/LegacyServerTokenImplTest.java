package com.example.jasper.sdklab.v1.server;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * @author Tom Koptel
 * @since 2.1
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class LegacyServerTokenImplTest {
    private static final TimeZone DEFAULT_TIMEZONE = TimeZone.getDefault();

    private static final String COOKIE1 = "cookie1";
    private static final String COOKIE2 = "cookie2";
    private static final String COOKIE_HEADER = "Set-Cookie";

    @Mock
    HttpHeaders mHeaders;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFilterOnlySet_CookieHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(COOKIE_HEADER, new ArrayList<String>() {{
            add(COOKIE1);
            add(COOKIE2);
        }});
        httpHeaders.put("strange-header", new ArrayList<String>());

        LegacyServerTokenImpl serverToken = new LegacyServerTokenImpl(mHeaders);
        List<String> result = serverToken.filterCookieHeaders(httpHeaders);

        assertThat(result.size(), is(2));
        assertThat(result, hasItem(COOKIE1));
        assertThat(result, hasItem(COOKIE2));
    }

    @Test
    public void shouldJoinCookieHeaders() {
        LegacyServerTokenImpl serverToken = new LegacyServerTokenImpl(mHeaders);
        StringBuilder result = serverToken.joinCookieHeaders(new ArrayList<String>() {{
            add(COOKIE1);
            add(COOKIE2);
        }});

        assertThat(result.toString(), is("cookie1;cookie2"));
    }

    @Test
    public void shouldAppendTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Helsinki"));

        LegacyServerTokenImpl serverToken = new LegacyServerTokenImpl(mHeaders);

        StringBuilder result = new StringBuilder();
        serverToken.appendTimeZone(result);

        assertThat(result.toString(), is(";userTimezone=Europe/Helsinki"));

        // Just in case any of the tests mess with the system-wide
        // default time zone, make sure we've set it back to what
        // it should be.
        TimeZone.setDefault(DEFAULT_TIMEZONE);
    }

    @Test
    public void shouldFormatHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(COOKIE_HEADER, new ArrayList<String>() {{
            add(COOKIE1);
            add(COOKIE2);
        }});

        LegacyServerTokenImpl serverToken = new LegacyServerTokenImpl(mHeaders);
        String token = serverToken.getValue();

        assertThat(token, is(notNullValue()));
        assertThat(token.trim().length(), is(not(0)));
    }
}
