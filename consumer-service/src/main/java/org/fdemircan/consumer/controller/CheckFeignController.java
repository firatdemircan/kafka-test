package org.fdemircan.consumer.controller;

import org.fdemircan.core.feigns.ProducerFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class CheckFeignController {

    private final ProducerFeign producerFeign;


    @GetMapping("/check")
    public String yy(){
        return producerFeign.getProducerString();
    }

}
