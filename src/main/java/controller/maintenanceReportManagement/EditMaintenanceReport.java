package controller.maintenanceReportManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.RepairRecord;
import service.RepairRecordService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.rmi.ssl.SslRMIClientSocketFactory;

@RestController
public class EditMaintenanceReport {
    @Autowired
    RepairRecordService repairRecordService;

    @RequestMapping("/editMaintenanceReport")
    public String edit(RepairRecord record){
        repairRecordService.updateById(record);
        return new RestResult().setMessage("成功").setCode(ResultCode.SUCCESS).toString();
    }
}
