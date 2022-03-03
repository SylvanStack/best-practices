package com.bp.scaffolding.domain.dto;

import com.bp.scaffolding.domain.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: 用户DTO
 * @author: hansiyuan
 * @date: 2022/3/2 6:05 PM
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户DTO")
@Data
public class UserDTO extends BaseDTO {

    private static final long serialVersionUID = 8030300876217295476L;

    @ApiModelProperty("用户id")
    @JsonIgnore
    private Long id;

    @ApiModelProperty("用户姓名")
    private String name;
}
