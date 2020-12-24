package pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 备件需求表
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PartRequire implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final long UNFINISHED = 0;
    private static final long FINISHED = 1;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer serviceId;

    @TableField(exist = false)
    private ServiceRecord serviceRecord;

    private Integer partId;

    @TableField(exist = false)
    private Part part;

    private Integer num;

    private Integer status;

}
