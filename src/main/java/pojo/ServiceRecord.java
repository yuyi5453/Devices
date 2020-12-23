package pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 维修记录表
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceRecord implements Serializable {

    private static final long serialVersionUID = 1L;



    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer recordId;

    @TableField(exist = false)
    private RepairRecord repairRecord;

    private Date distributeTime;

    @TableField("repair_record")
    private String detectRecordDescription;

    @TableField("repair_record")
    private String repairRecordDescription;

    private Date repairTime;

    private String workload;

    /**
     * 人工费
     */
    private BigDecimal laborCost;

    /**
     * 材料费
     */
    private BigDecimal materialCost;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 维修延迟程度
     */
    private Integer delayDegree;
}
