package pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 备件表
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Part implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 库存状态
     */
    public static final int NORMAL = 1;
    public static final int CRITICAL = 2;
    public static final int WARNING = 3;
    public static final int SHORT = 4;



    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String type;

    private Integer num;

    private Integer warnNum;

    private Integer status;


}
