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

    /*
    * 2020-12-29
    * author:psy
    * 查询报修信息以及关联的客户信息和设备信息
    * 参数1：customerName 客户姓名
    * 参数2：phone 客户移动电话
    * 参数3：repairTime 报修时间
    * 参数4：currentPage 分页的当前页码
    * */
    @RequestMapping("/getMaintenanceReport")
    public String get(String customerName, String phone, String repairTime, String currentPage){
        //设置条件构造器
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
        //设置分页
        IPage<RepairRecord> page = new Page<>();
        page.setCurrent(Integer.parseInt(currentPage));
        page.setSize(5);
        repairRecordService.getRecord(page, wrapper);
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(String.valueOf(page.getTotal()))
                .setData(page.getRecords())
                .toString();
    }

}
