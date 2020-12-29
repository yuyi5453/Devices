package controller.maintenanceReportManagement;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.RepairRecord;
import service.RepairRecordService;
import util.json.RestResult;
import util.json.ResultCode;

import java.util.List;

@RestController
public class GetMaintenanceReport {

    @Autowired
    RepairRecordService repairRecordService;

    @RequestMapping("/getMaintenanceReport")
    public String get(String customerName, String phone, String repairTime, String currentPage){
        QueryWrapper<RepairRecord> wrapper = new QueryWrapper<>();
        if(customerName != null && !customerName.trim().equals("")){
            wrapper.eq("customer_name",customerName);
        }
        if(phone != null && !customerName.trim().equals("")){
            wrapper.eq("phone",phone);
        }
        if(repairTime != null && !repairTime.trim().equals("")){
            wrapper.eq("repair_time",repairTime);
        }
        IPage<RepairRecord> page = new Page<>();
        page.setCurrent(Integer.parseInt(currentPage));
        //page.setCurrent(1);
        page.setSize(5);
        repairRecordService.getRecord(page, wrapper);

        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(String.valueOf(page.getTotal()))
                .setData(page.getRecords())
                .toString();
    }

}
