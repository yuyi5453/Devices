package controller.customerManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Customer;
import service.CustomerService;

@RestController
public class AddCustomerInfo {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/addCustomer")
    public String add(Customer customer){
        return customerService.updateCustomer(customer);
    }
}
