package controller.customerManagement;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Customer;
import service.CustomerService;
import util.json.RestResult;
import util.json.ResultCode;

import java.util.List;

@RestController
public class GetCustomerInfo {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/getCustomerInfo")
    public String getInfo(String idcard, String phone, String currentPage){
//        Customer customer = customerService.getOne(
//                new QueryWrapper<Customer>().eq("idcard",idcard)
//        );
        //根据传入参数设置条件构造器
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        if(idcard != null && !idcard.trim().equals("")){
            wrapper.eq("idcard",idcard);
        }
        if(phone != null && !phone.trim().equals("")){
            wrapper.eq("phone",phone);
        }
        //设置分页
        IPage<Customer> page = new Page<>();
        page.setCurrent(Integer.parseInt(currentPage));
        page.setSize(5);
        //执行分页查询
        customerService.page(page, wrapper);
        if (page.getRecords()==null) {
            return new RestResult().setCode(ResultCode.FAIL).setMessage("客户不存在").toString();
        }else {
            return new RestResult().setCode(ResultCode.SUCCESS).setMessage(String.valueOf(page.getTotal())).setData(page.getRecords()).toString();
        }
//        if (customer==null) {
//            return new RestResult().setCode(ResultCode.FAIL).setMessage("客户不存在").toString();
//        }else {
//            return new RestResult().setCode(ResultCode.SUCCESS).setMessage("客户信息").setData(customer).toString();
//        }
    }

    @RequestMapping("/getAllCustomer")
    public String getAllCustomer(){
        List<Customer> list = customerService.list();
        return new RestResult().setData(list).toString();
    }
}
