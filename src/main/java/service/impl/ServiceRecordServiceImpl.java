package service.impl;

import pojo.ServiceRecord;
import mapper.ServiceRecordMapper;
import service.ServiceRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
