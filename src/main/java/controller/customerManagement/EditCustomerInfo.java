package controller.customerManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Customer;
import service.CustomerService;

public class EditCustomerInfo {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/updateCustomer")
    public String update(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
}
