package com.bp.scaffolding.common.model;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @description: 文章
 * @author: hansiyuan
 * @date: 2022/2/28 6:53 PM
 */
@Data
@Builder
@JsonPropertyOrder(value = {"content", "title"})
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "文章Model")
public class Article {

    @JsonIgnore
    @ApiModelProperty(value = "文章id")
    private Long id;

    @JsonProperty("auther")
    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "读者")
    private List<Reader> reader;
}
