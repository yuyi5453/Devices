package service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import mapper.RepairRecordMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.RepairRecord;
import pojo.ServiceRecord;
import mapper.ServiceRecordMapper;
import pojo.User;
import service.ServiceRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public void Dispatch(Integer id,Integer userId){
        LambdaUpdateWrapper<ServiceRecord> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        User user=userMapper.selectById(userId);
        lambdaUpdateWrapper.eq(ServiceRecord::getId,id).set(ServiceRecord::getRepairManId,userId);
    }
}
