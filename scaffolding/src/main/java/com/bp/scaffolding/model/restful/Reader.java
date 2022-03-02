package com.bp.scaffolding.model.restful;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 读者Model
 * @author: hansiyuan
 * @date: 2022/2/28 6:54 PM
 */
@Data
@ApiModel(value = "读者Model")
public class Reader {
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;
}
