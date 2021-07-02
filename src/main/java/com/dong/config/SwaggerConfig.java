package com.dong.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        // (载明包裹、发货、完工等情况的)单据，标签; 备审案件目录表; 法院积案清单; 议程;
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dong.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("mybatis-plus")  //项目名称
                        .description("学生信息的操作，邮箱、定时任务、异步") //项目描述y
                        .version("1.0")   //版本信息
                        .contact(new Contact("mtb",
                                "http://dsc0306@163.com",
                                "dsc0306@163.com"))
                        //作者信息
                        .license("The Apache License")//许可证
                        .licenseUrl("http://www.baidu.com") //许可证url
                        .build());
    }
}