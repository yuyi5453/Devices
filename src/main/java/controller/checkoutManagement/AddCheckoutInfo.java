package controller.checkoutManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.ServiceRecord;
import service.ChargeService;
import service.ServiceRecordService;

import java.math.BigDecimal;

@Controller
public class AddCheckoutInfo {
    @Autowired
    private ChargeService chargeService;

    @RequestMapping("/addPartCost")
    public BigDecimal AddCheckoutInfo(ServiceRecord serviceRecord){
        return chargeService.updatePartCost(serviceRecord);
    }


}
