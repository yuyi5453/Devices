package service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import mapper.PartMapper;
import mapper.ServiceRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Charge;
import mapper.ChargeMapper;
import pojo.Part;
import pojo.ServiceRecord;
import service.ChargeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Service
public class ChargeServiceImpl extends ServiceImpl<ChargeMapper, Charge> implements ChargeService {
    @Autowired
    private ServiceRecordMapper serviceRecordMapper;
    @Autowired
    private PartMapper partMapper;

    public BigDecimal updatePartCost(ServiceRecord serviceRecord){
        BigDecimal partCost=new BigDecimal(0);
        Map<Part,Integer> part=serviceRecord.getPart();
        for(Part p:part.keySet()){
            partCost=p.getPrice().multiply(new BigDecimal(serviceRecord.getPart().get(p)));
            partCost=partCost.add(partCost);
        }
        serviceRecord.setMaterialCost(partCost);
        LambdaUpdateWrapper<ServiceRecord> updateWrapper=new LambdaUpdateWrapper<>();
        updateWrapper.eq(ServiceRecord::getId,serviceRecord.getId()).set(ServiceRecord::getMaterialCost,partCost);
        Integer rows=serviceRecordMapper.update(serviceRecord,updateWrapper);
        return partCost;
    }

    public BigDecimal totalAmount(ServiceRecord serviceRecord){
        BigDecimal laborCost=serviceRecord.getLaborCost();
        BigDecimal materialCost=serviceRecord.getMaterialCost();
        BigDecimal partCost=serviceRecord.getPartCost();
        return laborCost.add(materialCost).add(partCost);
    }
}
