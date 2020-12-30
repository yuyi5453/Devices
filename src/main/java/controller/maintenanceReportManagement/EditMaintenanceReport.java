package controller.maintenanceReportManagement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.Device;
import pojo.RepairRecord;

import pojo.User;

import service.DeviceService;

import service.RepairRecordService;
import service.UserService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@RestController
public class EditMaintenanceReport {
    @Autowired
    RepairRecordService repairRecordService;
    @Autowired

    UserService userService;

    DeviceService deviceService;

    @RequestMapping("/editMaintenanceReport")
    @ResponseBody
    public String edit(HttpServletRequest request){
        RepairRecord repairRecord = repairRecordService.getById(request.getParameter("repairRecordId"));
        repairRecord.setRepairTime(new Date(request.getParameter("reportTime")));
        repairRecord.setExpectedTime(new Date(request.getParameter("estimateCompleteTime")));
        repairRecord.setStatus(Integer.parseInt(request.getParameter("reportStatus")));
        repairRecordService.updateById(repairRecord);
        Device device = deviceService.getById(request.getParameter("deviceId"));
        device.setType(request.getParameter("deviceType"));
        device.setBrand(request.getParameter("deviceBrand"));
        device.setModel(request.getParameter("deviceModel"));
        device.setSeriesNum(request.getParameter("deviceSeries"));
        device.setFaultType(request.getParameter("faultType"));
        device.setMemery(request.getParameter("ram"));
        device.setHdd(request.getParameter("hdd"));
        device.setBattery(request.getParameter("battery"));
        device.setAcAdapter(request.getParameter("ACadapter"));
        device.setOpticalDrive(request.getParameter("CDROM"));
        deviceService.updateById(device);
        return new RestResult().setMessage("成功").setCode(ResultCode.SUCCESS).toString();
    }

    @RequestMapping("/getEngineer")
    public String getEngineer(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_type",User.TECHNICAL_ENGINEER);
        List<User> list = userService.list(wrapper);
        return new RestResult().setData(list).toString();
    }


}
