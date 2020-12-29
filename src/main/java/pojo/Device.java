package pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 报修设备表
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer recordId;

    @TableField(exist = false)
    private RepairRecord repairRecord;

    private String type;

    private String brand;

    /**
     * 型号
     */
    private String model;

    private String seriesNum;

    private String faultType;

    @TableField("HDD")
    private String hdd;

    private String memery;

    private String acAdapter;

    private String battery;

    private String opticalDrive;


}
