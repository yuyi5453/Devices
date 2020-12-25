package controller.inventoryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Part;
import service.PartService;
import util.json.RestResult;

import java.util.List;

@RestController
public class GetInventoryInfo {
    @Autowired
    PartService partService;

    @RequestMapping("/getInventoryInfo")
    public String getInventoryInfo(){
        List<Part> list = partService.list();
        return new RestResult().setData(list).toString();
    }
}
