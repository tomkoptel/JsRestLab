/*
 * Copyright © 2015 TIBCO Software, Inc. All rights reserved.
 * http://community.jaspersoft.com/project/jaspermobile-android
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of Jaspersoft Mobile for Android.
 *
 * Jaspersoft Mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jaspersoft Mobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Jaspersoft Mobile for Android. If not, see
 * <http://www.gnu.org/licenses/lgpl>.
 */

package com.example.jasper.sdklab.v1.common.token;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;

import com.example.jasper.sdklab.v1.server.ServerConfiguration;

/**
 * @author Tom Koptel
 * @since 2.0
 */
class BasicAccessTokenEncoder implements AccessTokenEncoder {
    private final ServerConfiguration mServerConfiguration;

    BasicAccessTokenEncoder(ServerConfiguration serverConfiguration) {
        mServerConfiguration = serverConfiguration;
    }

    @NonNull
    @Override
    public String encodeToken() {
        String organization = mServerConfiguration.getOrganization();
        String userId = mServerConfiguration.getUserId();
        if (TextUtils.isEmpty(userId)) {
            throw new IllegalStateException("User id should not be empty");
        }
        String password = mServerConfiguration.getPassword();
        if (TextUtils.isEmpty(password)) {
            throw new IllegalStateException("Password should not be empty");
        }

        String mergedName = TextUtils.isEmpty(organization)
                ? userId : (userId + "|" + organization);
        String salt = String.format("%s:%s", mergedName, password);
        return "Basic " + Base64.encodeToString(salt.getBytes(), Base64.NO_WRAP);
    }

}
