package com.paul90g.web.controllers;

import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StatusControllerTests {

    private static final int HELLO_REQUEST_TEST_VAL = 7;

    @Autowired
    private StatusController statusController;

    @Test
    public void helloRequestTest() throws IOException {
        Response response = statusController.helloRequest(HELLO_REQUEST_TEST_VAL);
        log.info("Called \"helloRequest\" from the HouseStatusService!");
        log.info("Response received: {}", response);

        HttpStatus status = HttpStatus.valueOf(response.status());
        String responseBody = readInputStream(response.body().asInputStream());
        log.info("Parsed response body: {}", responseBody);

        assertEquals(HttpStatus.OK, status);
        assertEquals(HELLO_REQUEST_TEST_VAL, Integer.parseInt(responseBody));
    }

    private String readInputStream(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader(is))) {
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            log.error("IOException thrown when reading the input stream in a test!");
            e.printStackTrace();
        }
        return sb.toString();
    }

}
