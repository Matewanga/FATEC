package io.github.fatec.introducao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    @GetMapping(value = "teste")
    public String teste() {
        String id = UUID.randomUUID().toString();
        return id;
    }

}
