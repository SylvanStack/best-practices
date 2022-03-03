package com.bp.scaffolding.domain.dto;

import com.bp.scaffolding.domain.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: 用户请求DTO
 * @author: hansiyuan
 * @date: 2022/3/2 6:08 PM
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户请求DTO")
@Data
public class UserRequestDTO extends BaseDTO {

    private static final long serialVersionUID = -7802393154000282703L;
    @ApiModelProperty(value = "用户Id")
    private Long id;
}
