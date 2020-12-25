package controller.inventoryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Part;
import service.PartService;
import util.json.RestResult;
import util.json.ResultCode;

@RestController
public class StockOut {
    @Autowired
    private PartService partService;

    @RequestMapping("/stockOut")
    public String out(Part p){
        Part part = partService.getById(p.getId());
        if(p.getNum()>part.getNum()){
            return new RestResult().setCode(ResultCode.FAIL).setMessage("库存不足").toString();
        }
        else{
            part.setNum(part.getNum()-p.getNum());
            if(part.getNum() == part.getWarnNum()){
                part.setStatus(Part.CRITICAL);
            }else if(part.getNum() < part.getWarnNum()){
                part.setStatus(Part.SHORT);
            }else if(part.getNum()==0){
                part.setStatus(Part.WARNING);
            }
        }
        return new RestResult().setCode(ResultCode.SUCCESS).setMessage("出库成功").toString();
    }
}
