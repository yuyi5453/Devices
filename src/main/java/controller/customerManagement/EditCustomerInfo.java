package controller.customerManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Customer;
import service.CustomerService;

@RestController
public class EditCustomerInfo {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/updateCustomer")
    public String update(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
}
