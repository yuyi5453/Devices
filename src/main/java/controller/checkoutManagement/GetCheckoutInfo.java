package controller.checkoutManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.ServiceRecord;
import service.ChargeService;

import java.math.BigDecimal;

@Controller
public class GetCheckoutInfo {
    @Autowired
    private ChargeService chargeService;

    @RequestMapping("/getTotalCost")
    public BigDecimal getTotalCost(ServiceRecord serviceRecord){
        return chargeService.totalAmount(serviceRecord);
    }
}
