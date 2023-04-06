package org.fdemircan.producer.controller.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("feign/firat")
public class TestFeignController {

    @GetMapping("test")
    public String xx(){
        return "I am From Feign Client";
    }


}
