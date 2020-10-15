package org.jetlinks.core.metadata;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zhouhao
 * @since 1.0.0
 */
public interface FunctionMetadata extends Metadata, Jsonable {

    /**
     * @return 输入参数定义
     */
    @NotNull
    List<PropertyMetadata> getInputs();

    /**
     * @return 输出类型
     */
    @NotNull
    DataType getOutput();

    /**
     * @return 是否异步
     */
    boolean isAsync();

}
