package com.yuanstack.bp.scaffolding.api.restful;

import com.yuanstack.bp.scaffolding.api.RestfulExampleController;
import com.yuanstack.bp.scaffolding.common.model.Article;
import com.yuanstack.bp.scaffolding.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(RestfulExampleController.class)
@Slf4j
public class RestfulExampleControllerTest {

    @Resource
    private  MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    //测试方法
    @Test
    public void saveArticleMock() throws Exception {

        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"auther\": \"hhh\",\n" +
                "    \"title\": \"hhhht\",\n" +
                "    \"content\": \"c123\",\n" +
                "    \"createTime\": \"2022-03-02 14:30:53\",\n" +
                "    \"reader\":[{\"name\":\"yyyyy\",\"age\":22},{\"name\":\"sssss\",\"age\":12}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Article articleObj = objectMapper.readValue(article,Article.class);

        //打桩
        when(articleService.saveArticle(articleObj)).thenReturn("ok");

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .request(HttpMethod.POST, "/api/rest/articles")
                                .header("header","hhh")
                                .contentType("application/json")
                                .content(article)
                )
//                .andExpect(MockMvcResultMatchers.status().isOk())  //HTTP:status 200
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok"))
                .andDo(print())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());

    }

    @Test
    void getArticle() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .request(HttpMethod.GET, "/api/rest/articles/1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())  //HTTP:status 200
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.auther").value("hhh"))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }

    @Test
    void saveArticle() throws Exception {
        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"hhh\",\n" +
                "    \"title\": \"hhhht\",\n" +
                "    \"content\": \"c123\",\n" +
                "    \"createTime\": \"2022-03-02 14:30:53\",\n" +
                "    \"reader\":[{\"name\":\"yyyyy\",\"age\":22},{\"name\":\"sssss\",\"age\":12}]\n" +
                "}";
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .request(HttpMethod.POST, "/api/rest/articles")
                                .header("header","hhh")
                                .contentType("application/json")
                                .content(article)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())  //HTTP:status 200
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }
}