package controller.maintenanceReportManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Device;
import pojo.RepairRecord;
import service.DeviceService;
import service.RepairRecordService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class AddMaintenanceReport {
    @Autowired
    private RepairRecordService repairRecordService;
    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/addMaintenanceReport")
    public String add(HttpServletRequest request){
        return repairRecordService.addRecord(request);
    }
}
