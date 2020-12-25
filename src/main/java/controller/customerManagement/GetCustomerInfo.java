package controller.customerManagement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Customer;
import service.CustomerService;
import util.json.RestResult;
import util.json.ResultCode;

@RestController
public class GetCustomerInfo {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/getCustomerInfo")
    public String getInfo(String idcard){
        Customer customer = customerService.getOne(
                new QueryWrapper<Customer>().eq("idcard",idcard)
        );
        if (customer==null) {
            return new RestResult().setCode(ResultCode.FAIL).setMessage("客户不存在").toString();
        }else {
            return new RestResult().setCode(ResultCode.SUCCESS).setMessage("客户信息").setData(customer).toString();
        }
    }
}
