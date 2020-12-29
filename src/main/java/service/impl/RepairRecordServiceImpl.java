package service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Device;
import pojo.RepairRecord;
import mapper.RepairRecordMapper;
import service.DeviceService;
import service.RepairRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class RepairRecordServiceImpl extends ServiceImpl<RepairRecordMapper, RepairRecord> implements RepairRecordService {

    @Autowired
    RepairRecordMapper repairRecordMapper;
    @Autowired
    private DeviceService deviceService;
    @Override

    public IPage getRecord(IPage page, Wrapper wrapper) {
        return repairRecordMapper.getRepairRecord(page, wrapper);
    }

    @Override
    public String addRecord(HttpServletRequest request) {
        String customerId = request.getParameter("customerId");
        System.out.println(customerId);
        RepairRecord repairRecord = new RepairRecord();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            repairRecord.setExpectedTime(sdf.parse(request.getParameter("expectedTime")));
        } catch (ParseException e) {
            e.printStackTrace();
            return "格式错误";
        }
        repairRecord.setRepairTime(new Date());
        repairRecord.setStatus(RepairRecord.INPROCESS);
        save(repairRecord);
        Integer recordId = repairRecord.getId();

        Device device = new Device();
        device.setRecordId(recordId);
        device.setType(request.getParameter("type"));
        device.setBrand(request.getParameter("brand"));
        device.setModel(request.getParameter("model"));
        device.setSeriesNum(request.getParameter("seriesNum"));
        device.setFaultType(request.getParameter("faultType"));
        device.setHdd(request.getParameter("hdd"));
        device.setMemery(request.getParameter(",memery"));
        device.setAcAdapter(request.getParameter("acAdapter"));
        device.setBattery(request.getParameter("battery"));
        device.setOpticalDrive(request.getParameter("opticalDrive"));

        deviceService.save(device);
        return null;
    }
}
