package controller.maintenanceReportManagement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.RepairRecord;
import pojo.User;
import service.RepairRecordService;
import service.UserService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.List;

@RestController
public class EditMaintenanceReport {
    @Autowired
    RepairRecordService repairRecordService;
    @Autowired
    UserService userService;

    @RequestMapping("/editMaintenanceReport")
    public String edit(RepairRecord record){
        repairRecordService.updateById(record);
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
