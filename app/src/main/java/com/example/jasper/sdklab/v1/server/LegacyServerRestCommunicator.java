package com.example.jasper.sdklab.v1.server;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.example.jasper.sdklab.v1.common.endpoint.Endpoint;
import com.example.jasper.sdklab.v1.common.endpoint.EndpointFactory;
import com.jaspersoft.android.sdk.client.JsRestClient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author Tom Koptel
 * @since 2.1
 */
class LegacyServerRestCommunicator implements ServerRestCommunicator {
    private final Endpoint mRestEndpoint;
    private final RestTemplate mRestTemplate;

    @VisibleForTesting
    LegacyServerRestCommunicator(@NonNull RestTemplate restTemplate, @NonNull ServerConfiguration serverConfiguration) {
        mRestTemplate = restTemplate;
        mRestEndpoint = EndpointFactory.createRestV2Endpoint(serverConfiguration);
    }

    static ServerRestCommunicator newInstance(@NonNull ServerConfiguration serverConfiguration) {
        JsRestClient jsRestClient = JsRestClient.builder()
                .setDataType(JsRestClient.DataType.JSON)
                .build();
        RestTemplate restTemplate = jsRestClient.getRestTemplate();
        return new LegacyServerRestCommunicator(restTemplate, serverConfiguration);
    }

    @NonNull
    @Override
    public ServerToken getServerToken() {
        Endpoint resourcesEndpoint = EndpointFactory.createResourcesEndpoint(mRestEndpoint);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/repository.folder+json");
        headers.add("Content-Type", "application/json");
        HttpEntity<String> httpEntity = new HttpEntity<String>("", headers);

        ResponseEntity<String> responseEntity = mRestTemplate.exchange(
                resourcesEndpoint.getValue(),
                HttpMethod.GET,
                httpEntity,
                String.class);
        HttpHeaders httpHeaders = responseEntity.getHeaders();

        return new LegacyServerTokenImpl(httpHeaders);
    }

    @NonNull
    @Override
    public ServerInfo getServerInfo() {
        throw new UnsupportedOperationException();
    }
}
