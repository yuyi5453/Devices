package mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import pojo.Device;
import pojo.RepairRecord;
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
public interface RepairRecordMapper extends BaseMapper<RepairRecord> {
    //public List<Map> getRepairRecord(@Param("phone") String phone);
    public IPage getRepairRecord(IPage page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
