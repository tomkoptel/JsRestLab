package com.example.jasper.sdklab.v1.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.URLUtil;

/**
 * @author Tom Koptel
 * @since 2.1
 */
public class ServerExecutionConfiguration implements Parcelable, ServerConfiguration {
    private String mBaseUrl;
    private String mUserId;
    private String mOrganization;
    private String mPassword;

    private ServerExecutionConfiguration() {}

    @CheckResult
    public static ServerExecutionConfiguration newInstance() {
        return new ServerExecutionConfiguration();
    }

    public ServerExecutionConfiguration withBaseUrl(@NonNull String baseUrl) {
        ensureSaneValue(baseUrl, "Base url should not be null or empty.");
        if (!URLUtil.isNetworkUrl(baseUrl)) {
            throw new IllegalArgumentException("Should be network urt, but was <" + baseUrl + ">");
        }
        mBaseUrl = baseUrl;
        return this;
    }

    public ServerExecutionConfiguration withUserId(@NonNull String userId) {
        ensureSaneValue(userId, "User identifier should not be null or empty.");
        mUserId = userId;
        return this;
    }

    public ServerExecutionConfiguration withOrganization(@Nullable String organization) {
        mOrganization = organization;
        return this;
    }

    public ServerExecutionConfiguration withPassword(@NonNull String password) {
        ensureSaneValue(password, "Password should not be null or empty.");
        mPassword = password;
        return this;
    }

    @NonNull
    @Override
    public String getBaseUrl() {
        return mBaseUrl;
    }

    @NonNull
    @Override
    public String getUserId() {
        return mUserId;
    }

    @Nullable
    @Override
    public String getOrganization() {
        return mOrganization;
    }

    @NonNull
    @Override
    public String getPassword() {
        return mPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerExecutionConfiguration that = (ServerExecutionConfiguration) o;

        if (!mBaseUrl.equals(that.mBaseUrl)) return false;
        if (!mUserId.equals(that.mUserId)) return false;
        if (mOrganization != null ? !mOrganization.equals(that.mOrganization) : that.mOrganization != null)
            return false;
        return mPassword.equals(that.mPassword);

    }

    @Override
    public int hashCode() {
        int result = mBaseUrl.hashCode();
        result = 31 * result + mUserId.hashCode();
        result = 31 * result + (mOrganization != null ? mOrganization.hashCode() : 0);
        result = 31 * result + mPassword.hashCode();
        return result;
    }

    private void ensureSaneValue(String value, String message) {
        if (TextUtils.isEmpty(value)) {
            throw new IllegalArgumentException(message + " Value was: " + value);
        }
        if (TextUtils.isEmpty(value.trim())) {
            throw new IllegalArgumentException("After trim. " + message + " Value was: " + value);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mBaseUrl);
        dest.writeString(this.mUserId);
        dest.writeString(this.mOrganization);
        dest.writeString(this.mPassword);
    }

    protected ServerExecutionConfiguration(Parcel in) {
        this.mBaseUrl = in.readString();
        this.mUserId = in.readString();
        this.mOrganization = in.readString();
        this.mPassword = in.readString();
    }

    public static final Creator<ServerExecutionConfiguration> CREATOR = new Creator<ServerExecutionConfiguration>() {
        public ServerExecutionConfiguration createFromParcel(Parcel source) {
            return new ServerExecutionConfiguration(source);
        }

        public ServerExecutionConfiguration[] newArray(int size) {
            return new ServerExecutionConfiguration[size];
        }
    };
}
