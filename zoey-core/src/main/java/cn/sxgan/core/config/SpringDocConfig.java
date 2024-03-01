package cn.sxgan.core.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: SpringDoc基本信息配置类
 * @Author: sxgan
 * @Date: 2024/3/1 15:12
 * @Version: 1.0
 **/
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI defaultOpenAPI() {
        return new OpenAPI().
                info(info())
                .externalDocs(documentation());
    }

    public Info info() {
        return new Info()
                .title("zoey major events")
                .version("V1.0.0")
                .description("zoey major events spring doc open api")
                .license(new License().name("Apache-2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact().name("sxgan").url("https://gitee.com/sxgan"))
                .summary("新闻发布系统");
    }

    public ExternalDocumentation documentation() {
        return new ExternalDocumentation().description("major events spring doc")
                .url("http://localhost:8080/v3/api-docs");
    }


}
