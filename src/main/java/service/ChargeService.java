package service;

import pojo.Charge;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.ServiceRecord;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
public interface ChargeService extends IService<Charge> {
    public BigDecimal updatePartCost(ServiceRecord serviceRecord);
    public BigDecimal totalAmount(ServiceRecord serviceRecord);
}
