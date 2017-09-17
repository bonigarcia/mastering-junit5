/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.ServerSocket;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.github.bonigarcia.mockito.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RemoteFileTest {

    @Spy
    RemoteFileService remoteFileService;

    WireMockServer wireMockServer;

    String baseUrl;

    // Test data
    String filename = "foo";
    String streamId = "1";
    String contentFile = "dummy";

    @BeforeEach
    void setup() throws Exception {
        // Look for free port
        int port;
        try (ServerSocket socket = new ServerSocket(0)) {
            port = socket.getLocalPort();
        }
        baseUrl = "http://localhost:" + port;

        // Mock server
        wireMockServer = new WireMockServer(options().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        // Stubbing service
        stubFor(post(urlEqualTo("/api/v1/paths/" + filename + "/open-file"))
                .willReturn(aResponse().withStatus(200).withBody(streamId)));
        stubFor(post(urlEqualTo("/api/v1/streams/" + streamId + "/read"))
                .willReturn(aResponse().withStatus(200).withBody(contentFile)));
        stubFor(post(urlEqualTo("/api/v1/streams/" + streamId + "/close"))
                .willReturn(aResponse().withStatus(200)));
    }

    @Test
    void testGetFile() throws IOException {
        Mockito.when(remoteFileService.getBaseUrl()).thenReturn(baseUrl);

        remoteFileService.initService();
        byte[] fileContent = remoteFileService.getFile(filename);

        assertEquals(contentFile.length(), fileContent.length);
    }

    @AfterEach
    void teardown() {
        wireMockServer.stop();
    }

}
