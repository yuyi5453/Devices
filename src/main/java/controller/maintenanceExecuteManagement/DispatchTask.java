package controller.maintenanceExecuteManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ServiceRecordService;
import util.json.RestResult;
import util.json.ResultCode;

@Controller
public class DispatchTask {
    @Autowired
    private ServiceRecordService serviceRecordService;

    @ResponseBody
    @RequestMapping("/diapatchTask")
    public void DispatchTask(Integer id,Integer userId){
        serviceRecordService.Dispatch(id,userId);
    }
}
