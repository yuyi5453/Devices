package controller.maintenanceExecuteManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.ServiceRecord;
import service.ServiceRecordService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@RestController
public class EditTaskInfo {
    @Autowired
    private ServiceRecordService serviceRecordService;

    @RequestMapping("/updateServiceRecord")
    public String EditTaskInfo(HttpServletRequest request){
        ServiceRecord serviceRecord = new ServiceRecord();
        serviceRecord.setId(Integer.valueOf(request.getParameter("id")));
        serviceRecord.setLaborCost(BigDecimal.valueOf(Double.parseDouble(request.getParameter("laborCost")==null?"0":request.getParameter("laborCost"))));
        serviceRecord.setMaterialCost(BigDecimal.valueOf(Double.parseDouble(request.getParameter("materialCost")==null?"0":request.getParameter("materialCost"))));
        serviceRecord.setDetectRecordDescription(request.getParameter("detectRecordDescription"));
        serviceRecord.setRepairRecordDescription(request.getParameter("repairRecordDescription"));

        serviceRecordService.updateById(serviceRecord);
        return new RestResult().setMessage("success").toString();
    }

    @RequestMapping("/dispatch")
    public String dispatch(String recordId,String repairManId){
        ServiceRecord serviceRecord = new ServiceRecord();
        serviceRecord.setId(Integer.parseInt(recordId));
        serviceRecord.setRepairManId(repairManId);
        serviceRecordService.updateById(serviceRecord);
        return new RestResult().setMessage("success").toString();
    }
}
