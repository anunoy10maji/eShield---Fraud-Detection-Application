package org.proj.Controller;


import org.proj.Fraud.FraudResult;
import org.proj.Service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fraud-validation/api/")
public class FraudDetectionController {
    @Autowired
    private FraudDetectionService fraudDetectionService;
    @GetMapping("{id}/{funcCode}/{transType}/{country}")
    public FraudResult checkFraud(@PathVariable("id") String id,@PathVariable("funcCode") String funcCode,
                                  @PathVariable("transType") String transType,@PathVariable("country") String country){
        return new FraudResult(fraudDetectionService.registerIfFraud(id,funcCode,country,transType));
    }
}
