package service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import pojo.Device;
import pojo.RepairRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
public interface RepairRecordService extends IService<RepairRecord> {
    public IPage getRecord(IPage page, Wrapper wrapper);
    public String addRecord(HttpServletRequest request);
}
