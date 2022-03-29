package com.yuanstack.bp.scaffolding.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 接口文档配置
 * @author: hansiyuan
 * @date: 2022/3/2 3:35 PM
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    private static final String AUTH_HEADER_NAME = "token";

    @Resource
    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean
    public Docket example() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的方法，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //特定包下的类，才生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.yuanstack.bp.scaffolding.api.restful"))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions("default"))
                //设置全局token
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
        //每个接口传token
        //.globalRequestParameters(globalRequestParameters());
    }

//    @Bean
//    public Docket cms() {
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                .select()
//                //加了ApiOperation注解的方法，才生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                //特定包下的类，才生成接口文档
//                .apis(RequestHandlerSelectors.basePackage("com.yuanstack.bp.scaffolding.cms"))
//                .paths(PathSelectors.any())
//                .build()
//                .extensions(openApiExtensionResolver.buildExtensions("cms"))
//                //设置全局token
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts());
//        //每个接口传token
//        //.globalRequestParameters(globalRequestParameters());
//    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                .select()
//                //加了ApiOperation注解的方法，才生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                //特定包下的类，才生成接口文档
//                .apis(RequestHandlerSelectors.basePackage("com.yuanstack.bp.scaffolding.api"))
//                .paths(PathSelectors.any())
//                .build()
//                .extensions(openApiExtensionResolver.buildExtensions("api"))
//                //设置全局token
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts());
//        //每个接口传token
//        //.globalRequestParameters(globalRequestParameters());
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("通用脚手架系统")
                .description("通用脚手架系统接口文档")
                .termsOfServiceUrl("https://www.yuque.com/books/share/e9ef3365-64bb-4355-ba50-c4b82d282f17")
                .contact(new Contact("彧安", "https://www.yuque.com/books/share/e9ef3365-64bb-4355-ba50-c4b82d282f17", "422295068@qq.com"))
                .version("1.0.0")
                .build();
    }

    private List<SecurityScheme> securitySchemes() {
        return Arrays.asList(new ApiKey(AUTH_HEADER_NAME, "auth", In.HEADER.name()));
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext
                .builder()
                .securityReferences(securityReferences())
                .operationSelector(operationContext -> operationContext.requestMappingPattern().startsWith("/api/"))
                .build());
        return securityContexts;
    }

    private List<SecurityReference> securityReferences() {
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")};
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference(AUTH_HEADER_NAME, authorizationScopes));
        return securityReferences;
    }

    private List<RequestParameter> globalRequestParameters() {
        return Arrays.asList(new RequestParameterBuilder()
                .name(AUTH_HEADER_NAME)
                .description("access token")
                .in(ParameterType.HEADER)
                .required(false)
                .build());
    }
}
