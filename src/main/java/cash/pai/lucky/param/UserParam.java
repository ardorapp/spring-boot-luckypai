package cash.pai.lucky.param;

import lombok.Data;
import javax.validation.constraints.NotNull;


/**
 * 接收前端参数
 */
@Data
public class UserParam {
    @NotNull(message="不能为空")
    private String userId;

}
