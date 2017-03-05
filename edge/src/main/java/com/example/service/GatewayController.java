package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by surasak on 3/5/17.
 */
@RestController
public class GatewayController {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getProductsBreaker")
    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getProducts(){
        Object obj  = restTemplate.getForEntity("http://product-service/products", Object[].class);
        return new ResponseEntity(obj, HttpStatus.OK);
    }


    @HystrixCommand(fallbackMethod = "getProductBreaker")
    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getProduct(@PathVariable int id){
        Object obj  = restTemplate.getForEntity("http://product-service/product/{id}", Object[].class, id);
        return new ResponseEntity(obj, HttpStatus.OK);
    }

    private ResponseEntity getProductsBreaker() {
        return new ResponseEntity("Service Products Down.", HttpStatus.NO_CONTENT);
    }

    private ResponseEntity getProductBreaker(int id) {
        return new ResponseEntity("Service getProduct Down.", HttpStatus.NO_CONTENT);
    }

}
