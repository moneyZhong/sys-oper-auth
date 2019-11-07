package com.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Profile({"!prod"})
@Configuration
@EnableSwagger2
@Order(3)
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.sys.web"))
                .paths(PathSelectors.any()).build();
    }

    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("系统API").description("系统API").termsOfServiceUrl("").version("1.0").build();
    }
    

	 
   /*
    @Bean
    public Docket innerApi() {
    	
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("innerApi")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sys.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(innerApiInfo());
    }
 
    @Bean
    public Docket openApi() {
    	
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("openApi")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gcp.finance.ucd.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(openApiInfo());
    }
 
    private ApiInfo innerApiInfo() {
        return new ApiInfoBuilder()
            .title("内部查询")//大标题
            .description("内部api")//详细描述
            .version("1.0")//版本
            .build();
    }
 
    private ApiInfo openApiInfo() {
        return new ApiInfoBuilder()
            .title("全部查询")//大标题
            .description("全部api")//详细描述
            .version("1.0")//版本
            .build();
    }*/

    
    
    
    
}
