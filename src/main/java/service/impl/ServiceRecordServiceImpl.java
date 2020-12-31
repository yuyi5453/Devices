package service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import mapper.RepairRecordMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pojo.*;
import mapper.ServiceRecordMapper;
import service.ServiceRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import util.json.RestResult;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Service
public class ServiceRecordServiceImpl extends ServiceImpl<ServiceRecordMapper, ServiceRecord> implements ServiceRecordService {
    @Autowired
    private ServiceRecordMapper serviceRecordMapper;
    @Autowired
    private UserMapper userMapper;

    public List<ServiceRecord> selectUndispatchedTask(Integer status){
        QueryWrapper<ServiceRecord> queryWrapper=new QueryWrapper<>();
        List<ServiceRecord> list=serviceRecordMapper.selectList(queryWrapper.lambda().eq(ServiceRecord::getStatus,status));
        return list;
    }

    public void updateTask(ServiceRecord serviceRecord) {
        serviceRecordMapper.updateById(serviceRecord);
    }

    @Override
    public String getServiceRecord(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        if(phone!=null){
            wrapper.eq("phone", phone);
        }
        List<Map> serviceRecords = serviceRecordMapper.getServiceRecord(wrapper);

        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for(Map m : serviceRecords){
            HashMap<String, Object> hs = new HashMap<>();
            hs.put("customerName",m.get("customer_name"));
            hs.put("phone",m.get("phone"));
            hs.put("repairTime",m.get("report_time"));
            hs.put("deviceType",m.get("type"));
            hs.put("deviceBrand",m.get("brand"));
            hs.put("deviceModel",m.get("model"));
            hs.put("seriesNum",m.get("series_num"));
            hs.put("status",m.get("s_status"));
            if(!StringUtils.isEmpty(m.get("repair_man_id"))){
                System.out.println(m.get("repair_man_id"));
                hs.put("engineer",userMapper.selectById(m.get("repair_man_id").toString()).getUserName());
            }


            /*
            向前端传递客户信息
             */
            Customer customer = new Customer();
            customer.setId((Integer) m.get("cid"));
            customer.setIdcard((String) m.get("idcard"));
            customer.setPhone((String) m.get("phone"));
            customer.setCustomerName((String) m.get("customer_name"));
            customer.setAddress((String) m.get("address"));
            customer.setCompanyName((String) m.get("company_name"));
            customer.setEmail((String) m.get("email"));
            customer.setCustomerType((String) m.get("customer_type"));
            hs.put("customer",customer);

            /*
            向前端传递设备信息
             */
            Device device = new Device();
            device.setId((Integer) m.get("did"));
            device.setType((String) m.get("type"));
            device.setBrand((String) m.get("brand"));
            device.setModel((String) m.get("model"));
            device.setSeriesNum((String) m.get("series_num"));
            device.setFaultType((String) m.get("fault_type"));
            device.setHdd((String) m.get("HDD"));
            device.setMemery((String) m.get("memery"));
            device.setAcAdapter((String) m.get("ac_adapter"));
            device.setBattery((String) m.get("battery"));
            device.setOpticalDrive((String) m.get("optical_drive"));
            hs.put("device",device);

            /*
            向前端传递报修记录信息
             */
            ServiceRecord serviceRecord = new ServiceRecord();
            serviceRecord.setId((Integer) m.get("sid"));
            serviceRecord.setRepairManId((String) m.get("repair_man_id"));
            serviceRecord.setDistributeTime((Date) m.get("distribute_time"));
            serviceRecord.setDetectRecordDescription((String) m.get("detect_record"));
            serviceRecord.setRepairRecordDescription((String) m.get("repair_record"));
            serviceRecord.setWorkload((String) m.get("workload"));
            serviceRecord.setLaborCost((BigDecimal) m.get("labor_cost"));
            serviceRecord.setMaterialCost((BigDecimal) m.get("material_cost"));
            serviceRecord.setDelayDegree((Integer) m.get("delay_degree"));
            serviceRecord.setStatus((Integer) m.get("s_status"));
            hs.put("serviceRecord",serviceRecord);

            list.add(hs);
        }

        System.out.println(list);
        return new RestResult().setData(list).toString();
    }

    public void Dispatch(Integer id,Integer userId){
        LambdaUpdateWrapper<ServiceRecord> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        ServiceRecord serviceRecord=serviceRecordMapper.selectById(id);
        lambdaUpdateWrapper.eq(ServiceRecord::getId,id).set(ServiceRecord::getRepairManId,userId);
        Integer rows=serviceRecordMapper.update(serviceRecord,lambdaUpdateWrapper);
    }
}
