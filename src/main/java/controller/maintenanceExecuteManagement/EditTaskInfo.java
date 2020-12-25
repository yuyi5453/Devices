package controller.maintenanceExecuteManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pojo.ServiceRecord;
import service.ServiceRecordService;
import util.json.RestResult;
import util.json.ResultCode;

@Controller
public class EditTaskInfo {
    @Autowired
    private ServiceRecordService serviceRecordService;
    public void EditTaskInfo(ServiceRecord serviceRecord){
        serviceRecordService.updateTask(serviceRecord);
    }
}
