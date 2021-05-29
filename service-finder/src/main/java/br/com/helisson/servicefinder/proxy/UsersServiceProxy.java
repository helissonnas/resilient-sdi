package br.com.helisson.servicefinder.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name="users-service", url="users-service:8080")
public interface UsersServiceProxy {
    @PostMapping("report/{userId}/{featureFailedName}/{similarFeatureName}")
    @ResponseBody
    ResponseEntity report(
            @PathVariable String userId,
            @PathVariable String featureFailedName,
            @PathVariable String similarFeatureName
    );
}
