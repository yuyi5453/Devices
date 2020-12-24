package controller.maintenanceReportManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.RepairRecord;
import service.RepairRecordService;
import util.json.RestResult;
import util.json.ResultCode;

import java.util.Date;

@RestController
public class AddMaintenanceReport {
    @Autowired
    private RepairRecordService repairRecordService;

    @RequestMapping("/addMaintenanceReport")
    public String add(RepairRecord record){
        record.setStatus(RepairRecord.INPROCESS);
        record.setRepairTime(new Date());
        repairRecordService.save(record);
        return new RestResult().setCode(ResultCode.SUCCESS).setMessage("成功").toString();
    }
}
