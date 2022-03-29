package com.yuanstack.bp.scaffolding.api;

import com.yuanstack.bp.scaffolding.common.base.ResponseDTO;
import com.yuanstack.bp.scaffolding.common.model.Article;
import com.yuanstack.bp.scaffolding.service.ArticleService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: RESTful风格API示例
 * @author: hansiyuan
 * @date: 2022/2/28 6:26 PM
 */
@RestController
@RequestMapping("/api/rest")
@Slf4j
@Api("Restful示例")
public class RestfulExampleController {

    @Resource
    private ArticleService articleService;

    /**
     * 获取一篇Article，使用GET方法,根据id查询一篇文章
     */
    @ApiOperation(value = "获取一篇文章", notes = "获取一篇文章", tags = "Article", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章Id", required = true, dataType = "Long"),
    })
    @GetMapping("/articles/{id}")
    public ResponseDTO getArticle(@PathVariable("id") Long id) {
        //使用lombok提供的builder构建对象
        Article article = Article.builder()
                .id(id)
                .author("hhh")
                .content("这是一篇好文章")
                .createTime(new Date())
                .title("111").build();

        log.info("article:" + article);
        return ResponseDTO.success(article);
    }


    /**
     * 增加一篇Article ，使用POST方法(RequestBody方式接收参数)
     */
    @ApiOperation(value = "增加一篇文章", notes = "增加一篇文章", tags = "Article", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Article", value = "文章", required = true, dataType = "JSON"),
    })
    @PostMapping("/articles")
    public ResponseDTO saveArticle(@RequestBody Article article,
                                   @RequestHeader String header) {
        log.info("saveArticle:" + article);
        String result = articleService.saveArticle(article);
        return ResponseDTO.success(result);
    }

    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     */
    @ApiOperation(value = "更新一篇一篇文章", notes = "更新一篇一篇文章", tags = "Article", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Article", value = "文章", required = true, dataType = "JSON"),
    })
    @PutMapping("/articles")
    public ResponseDTO updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            //article.id是必传参数，因为通常根据id去修改数据
            //TODO 抛出一个自定义的异常
            log.error("error");
        }
        log.info("updateArticle:" + article);
        return ResponseDTO.success();
    }

    /**
     * 删除一篇Article，使用DELETE方法，参数是id
     */
    @ApiOperation(value = "删除一篇文章", notes = "删除一篇文章", tags = "Article", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章Id", required = true, dataType = "Long"),
    })
    @DeleteMapping("/articles/{id}")
    public ResponseDTO deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle:" + id);
        return ResponseDTO.success();
    }

}