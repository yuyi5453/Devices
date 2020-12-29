package mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import pojo.ServiceRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
public interface ServiceRecordMapper extends BaseMapper<ServiceRecord> {
    public List<Map> getServiceRecord(@Param(Constants.WRAPPER) Wrapper ew);
}
