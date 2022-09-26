package com.planet.kafkaproducer.controller;

import com.planet.kafkaproducer.service.DomainProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class DomainProducerController {

    private DomainProducerService service;

    public DomainProducerController(DomainProducerService service){
        this.service = service;
    }

    @GetMapping("/lookup/{name}")
    public String lookup(@PathVariable final String name){
        service.crawl(name);
        return "Domains sent to kafka";
    }
}
