package com.ssm.QAServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xiabin on 2017/5/26.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createTestApi() throws Exception{
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ssm.QAServer.web"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() throws  Exception{
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建restful APIs")
                .description("这是电信深交所项目")
                .termsOfServiceUrl("http://www.wust.edu.cn/default.html")
                .version("1.0")
                .build();
    }

}
