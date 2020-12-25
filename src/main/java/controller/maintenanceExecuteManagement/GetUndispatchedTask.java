package controller.maintenanceExecuteManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.RepairRecord;
import pojo.ServiceRecord;
import service.RepairRecordService;
import service.ServiceRecordService;
import util.json.RestResult;
import util.json.ResultCode;

import java.util.List;

@Controller
public class GetUndispatchedTask {
    @Autowired
    private ServiceRecordService serviceRecordService;

    @RequestMapping("/showUndispatched")
    @ResponseBody
    public String getUndispatchedTask(){
        List<ServiceRecord> list=serviceRecordService.selectUndispatchedTask(ServiceRecord.UNASSIGNED);
        return new RestResult().setCode(ResultCode.SUCCESS).setData(list).toString();
    }

}
