package controller.maintenanceReportManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.ServiceRecord;
import service.ServiceRecordService;
import util.json.RestResult;
import util.json.ResultCode;

@Controller
public class PostConfirmationForm {
    @Autowired
    ServiceRecordService serviceRecordService;

    @RequestMapping("/postConfirmationForm")
    @ResponseBody
    public String postConfirmationForm(String repairRecordId){
        ServiceRecord serviceRecord = new ServiceRecord();
        serviceRecord.setRecordId(Integer.parseInt(repairRecordId));
        serviceRecord.setStatus(ServiceRecord.UNASSIGNED);
        serviceRecordService.save(serviceRecord);
        return new RestResult().setCode(ResultCode.SUCCESS).toString();
    }
}
