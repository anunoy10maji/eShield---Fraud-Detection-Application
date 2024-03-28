package org.proj.Fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudCheckClient {

    @GetMapping("fraud-validation/api/{id}/{funcCode}/{transType}/{country}")
    FraudResult checkFraud(@PathVariable("id") String id,@PathVariable("funcCode") String funcCode,
                           @PathVariable("transType") String transType,@PathVariable("country") String country);
}
