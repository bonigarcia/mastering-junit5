
package io.github.bonigarcia;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
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

import com.github.tomakehurst.wiremock.WireMockServer;

public class RemoteFileTest {

    RemoteFileService remoteFileService;
    WireMockServer wireMockServer;

    // Test data
    String filename = "foo";
    String streamId = "1";
    String contentFile = "dummy";

    @BeforeEach
    void setup() throws Exception {
        // Look for free port for SUT instantiation
        int port;
        try (ServerSocket socket = new ServerSocket(0)) {
            port = socket.getLocalPort();
        }
        remoteFileService = new RemoteFileService("http://localhost:" + port);

        // Mock server
        wireMockServer = new WireMockServer(options().port(port));
        wireMockServer.start();
        configureFor("localhost", wireMockServer.port());

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
        byte[] fileContent = remoteFileService.getFile(filename);
        assertEquals(contentFile.length(), fileContent.length);
    }

    @AfterEach
    void teardown() {
        wireMockServer.stop();
    }

}
