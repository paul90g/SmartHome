package com.paul90g.web.controllers;

import feign.Response;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class StatusControllerTests {

    private static final int HELLO_REQUEST_TEST_VAL = 7;

    @Autowired
    private StatusController statusController;

    @Test
    void helloRequestTest() throws IOException {
        Response response = statusController.helloRequest(HELLO_REQUEST_TEST_VAL);
        log.info("Called \"helloRequest\" from the HouseStatusService!");
        log.info("Response received: {}", response);

        HttpStatus status = HttpStatus.valueOf(response.status());
        String responseHeader = response.headers().entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("\n"));
        log.info("Parsed response header: {}", responseHeader);
        String responseBody = readInputStream(response.body().asInputStream());
        log.info("Parsed response body: {}", responseBody);

        assertEquals(HttpStatus.OK, status);
        assertEquals(HELLO_REQUEST_TEST_VAL, Integer.parseInt(responseBody));
        assertTrue(responseHeader.contains(MediaType.APPLICATION_JSON_VALUE));
    }

    /**
     * Read all the data from an {@link InputStream} and convert it into a {@link String}
     *
     * @param is the {@link InputStream} to read data from
     * @return A {@link String} containing everything that was read from the input stream
     * @throws IOException thrown if there is an IO error with the data stream
     */
    private String readInputStream(@NonNull InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        Reader reader = new BufferedReader(new InputStreamReader(is));
        int c;
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        is.close();
        return sb.toString();
    }

}
