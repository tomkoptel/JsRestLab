package com.example.jasper.sdklab.v1.server;

import android.os.Parcel;
import android.os.Parcelable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowParcel;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tom Koptel
 * @since 2.1
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, shadows = {ShadowParcel.class})
public class ServerConfigurationParcelableTest {

    private ServerConfiguration configuration;

    @Before
    public void setup() {
        configuration = ServerConfiguration.newInstance();
    }

    @Test
    public void urlShouldBeParcelable() {
        String url = "http://localhost/";
        configuration.withBaseUrl(url);
        ServerConfiguration afterConfig = serializeConfig();
        assertThat(afterConfig.getBaseUrl(), is(url));
    }

    @Test
    public void userIdShouldBeParcelable() {
        String userId = "some_user";
        configuration.withUserId(userId);
        ServerConfiguration afterConfig = serializeConfig();
        assertThat(afterConfig.getUserId(), is(userId));
    }

    @Test
    public void organizationShouldBeParcelable() {
        String organization = "organization";
        configuration.withOrganization(organization);
        ServerConfiguration afterConfig = serializeConfig();
        assertThat(afterConfig.getOrganization(), is(organization));
    }

    @Test
    public void passwordShouldBeParcelable() {
        String password = "pass";
        configuration.withPassword(password);
        ServerConfiguration afterConfig = serializeConfig();
        assertThat(afterConfig.getPassword(), is(password));
    }

    private ServerConfiguration serializeConfig() {
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(configuration, 0);
        parcel.setDataPosition(0);

        Parcelable config = parcel.readParcelable(ServerConfiguration.class.getClassLoader());
        if (config == null) {
            throw new NullPointerException("Failed to read config from parcel");
        }
        parcel.recycle();

        return (ServerConfiguration) config;
    }

}
