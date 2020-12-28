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
        String customerId = request.getParameter("customerId");
        System.out.println(customerId);
        RepairRecord repairRecord = new RepairRecord();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            repairRecord.setExpectedTime(sdf.parse(request.getParameter("expectedTime")));
        } catch (ParseException e) {
            e.printStackTrace();
            return "格式错误";
        }
        repairRecord.setRepairTime(new Date());
        repairRecord.setStatus(RepairRecord.INPROCESS);
        repairRecordService.save(repairRecord);
        Integer recordId = repairRecord.getId();

        Device device = new Device();
        device.setRecordId(recordId);
        device.setType(request.getParameter("type"));
        device.setBrand(request.getParameter("brand"));
        device.setModel(request.getParameter("model"));
        device.setSeriesNum(request.getParameter("seriesNum"));
        device.setFaultType(request.getParameter("faultType"));
        device.setHdd(request.getParameter("hdd"));
        device.setMemery(request.getParameter(",memery"));
        device.setAcAdapter(request.getParameter("acAdapter"));
        device.setBattery(request.getParameter("battery"));
        device.setOpticalDrive(request.getParameter("opticalDrive"));

        deviceService.save(device);
        return null;

    }
}
