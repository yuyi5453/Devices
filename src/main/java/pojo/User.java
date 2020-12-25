package pojo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 560
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int CUSTOM_SERVICE=1;
    public static final int TASK_DISPATCHER=2;
    public static final int TECHNICAL_ENGINEER=3;
    public static final int INVENTORY_MANAGER=4;
    public static final int OPERATION_SUPERVISOR=5;

    private String id;

    private String password;

    private String userName;

    private Integer userType;

}
