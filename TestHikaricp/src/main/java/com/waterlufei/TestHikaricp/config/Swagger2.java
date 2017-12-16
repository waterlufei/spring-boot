package com.waterlufei.TestHikaricp.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by lzz on 2017/6/3.
 * 在线接口文档swagger2的配置文件
 */
/*@Configuration
@EnableSwagger2*/
public class Swagger2 {

    //以文档的方式输出到在线文档
    @Bean
    public Docket createTestApi() throws Exception{
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.waterlufei.TestHikaricp.web"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() throws  Exception{
        return new ApiInfoBuilder()
                .title("测试的APIs")
                .description("这是测试的项目")
                .termsOfServiceUrl("http://www.wust.edu.cn/default.html")
                .contact("武汉科技大学计算机学院ontoweb实验室")
                .version("1.0")
                .build();
    }
}
