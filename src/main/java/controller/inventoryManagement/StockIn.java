package controller.inventoryManagement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Part;
import service.PartService;
import util.json.RestResult;
import util.json.ResultCode;

@RestController
public class StockIn {
    @Autowired
    private PartService partService;

    @RequestMapping("/stockIn")
    public String in(Part p){
        String name = p.getName();
        String type = p.getType();
        Part part = partService.getOne(new QueryWrapper<Part>().eq("name", name).eq("type", type));
        if(part==null){
            p.setWarnNum(p.getNum()/2);
            p.setStatus(p.NORMAL);
            partService.save(p);
        }else{
            part.setNum(part.getNum()+part.getNum());
            if(part.getNum() > part.getWarnNum()){
                part.setStatus(Part.NORMAL);
            }else if(part.getNum() == part.getWarnNum()){
                part.setStatus(Part.CRITICAL);
            }else if(part.getNum() < part.getWarnNum()){
                part.setStatus(Part.SHORT);
            }else if(part.getNum()==0){
                part.setStatus(Part.WARNING);
            }
            partService.updateById(part);
        }
        return new RestResult().setCode(ResultCode.SUCCESS).setMessage("入库成功").toString();
    }
}
