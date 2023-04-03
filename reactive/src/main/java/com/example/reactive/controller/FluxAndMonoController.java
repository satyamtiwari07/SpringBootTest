package com.example.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class FluxAndMonoController {
    @GetMapping("/flux")
    public Flux<Integer> PrintingFluxValue(){
        return Flux.just(1,2,3,4)
                .log();
    }

    @GetMapping("/mono")
    public Mono<Integer> PrintingMonoValue(){
        return Mono.just(1)
                .log();
    }



}
