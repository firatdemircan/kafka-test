package org.fdemircan.core.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "producer-service/feign")
public interface ProducerFeign {

    @GetMapping("firat/test")
    String getProducerString();
}
