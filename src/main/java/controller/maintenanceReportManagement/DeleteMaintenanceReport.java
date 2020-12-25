package controller.maintenanceReportManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.RepairRecord;
import service.RepairRecordService;
import util.json.RestResult;
import util.json.ResultCode;

@RestController
public class DeleteMaintenanceReport {

    @Autowired
    RepairRecordService repairRecordService;

    @RequestMapping("/deleteMaintenanceReport")
    public String deleteMaintenanceReport(RepairRecord record){
        repairRecordService.removeById(record.getId());
        return new RestResult().setMessage("成功").setCode(ResultCode.SUCCESS).toString();
    }
}
