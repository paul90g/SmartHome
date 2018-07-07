package com.paul90g.status;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/status")
public class StatusController {

    @RequestMapping(value = "/hello/{testVal}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> helloRequest(@PathVariable int testVal) {
        log.info("helloRequest: testVal={}", testVal);
        return new ResponseEntity<>("Hello " + testVal, HttpStatus.OK);
    }

}
