package service.impl;

import com.sun.xml.internal.org.jvnet.fastinfoset.RestrictedAlphabet;
import pojo.Customer;
import mapper.CustomerMapper;
import service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import util.json.RestResult;
import util.json.ResultCode;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public String updateCustomer(Customer customer) {
        if(customer.getId()!=null) {
            this.updateById(customer);
        }
        else{
            this.save(customer);
            log.debug(customer.getId().toString());
        }
        return new RestResult().setMessage("更新成功").setCode(ResultCode.SUCCESS).toString();
    }
}
