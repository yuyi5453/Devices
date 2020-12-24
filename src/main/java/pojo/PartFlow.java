package pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 备件流水表
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PartFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer partId;

    @TableField(exist = false)
    private Part part;

    private Integer num;


}
