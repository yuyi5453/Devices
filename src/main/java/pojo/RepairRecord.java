package pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 报修记录表
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RepairRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer repairManId;

    @TableField(exist = false)
    private Customer repairMan;

    private Date repairTime;

    private Date expectedTime;

    private Integer status;

}
