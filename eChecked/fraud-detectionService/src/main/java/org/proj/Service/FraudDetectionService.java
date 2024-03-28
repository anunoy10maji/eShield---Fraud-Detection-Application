package org.proj.Service;

import org.proj.Entity.FraudHistory;
import org.proj.Repository.FraudDetectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudDetectionService {

    @Autowired
    private FraudDetectionRepo fraudDetectionRepo;

    public boolean registerIfFraud(String customerId,String functionCode,String country,String transType){
        boolean isFraud=false;
        isFraud=checkFraud(customerId,functionCode,country,transType);
        FraudHistory fraudHistory=FraudHistory.builder()
                .customerId(customerId).transType(transType)
                .functionCode(functionCode).isFraud(isFraud).createdAt(LocalDateTime.now()).build();
        fraudDetectionRepo.save(fraudHistory);
        return isFraud;
    }

    private boolean checkFraud(String customerId, String functionCode,String country,String transType) {
        if(!country.equalsIgnoreCase("india") || transType.equalsIgnoreCase("upi")){
            return true;
        }
        if(!functionCode.contains("P") || functionCode.isEmpty()){
            return true;
        }
        return false;
    }


}
