package com.paul90g.web.controllers;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("HouseStatusService")
public interface StatusController {

    @RequestMapping(method = RequestMethod.GET,
            value = "/hello/{testVal}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Response helloRequest(@PathVariable(value = "testVal") int testVal);

}
