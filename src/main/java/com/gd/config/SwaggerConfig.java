package com.gd.config;

import com.gd.jdbc.ControllerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2020/1/30.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    private Docket docket;
    private Contact michaelSun;
    private boolean aBoolean;

    @Bean
    public Docket rdocket(Environment environment){
        //设置要返回的运行环境，是开发环境还是生产环境还是其他。。。
        Profiles profiles=Profiles.of("dev");
        aBoolean = environment.acceptsProfiles(profiles);
        System.out.println(aBoolean);
        docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(apiInfo())
                .groupName("hello Michael")  //描述Docket查询，即可以是多个Docket，对每个Docket定义名称
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gd.jdbc"))

                //.apis(RequestHandlerSelectors.)
                .build();
        return docket;
    }
    private ApiInfo apiInfo(){
        michaelSun = new Contact("MichaelSun", "www.kk.com", "22@qq.com");

        return new ApiInfoBuilder()
                        .title("hello swagger")
                        .description("hello description")

                        //.licenseUrl("hello licenseUrk")
                        .version("1.0")
                        .contact(michaelSun)
                        //.license("hello license")
                        .title("hello controller Service")
                        .build();

                /*new ApiInfo("Api Documentation",
                        "Api Documentation",
                        "1.0",
                        "urn:tos", DEFAULT_CONTACT,
                        "Apache 2.0",
                        "http://www.apache.org/licenses/LICENSE-2.0")
                );*/
    }
}
