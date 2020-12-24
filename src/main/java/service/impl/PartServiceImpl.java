package service.impl;

import pojo.Part;
import mapper.PartMapper;
import service.PartService;
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
public class PartServiceImpl extends ServiceImpl<PartMapper, Part> implements PartService {

}
