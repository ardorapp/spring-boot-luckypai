package cash.pai.lucky.common.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${info.app.name}")
	private String appName;
	@Value("${info.app.version}")
	private String appVersion;
	@Value("${info.app.url}")
	private String appUrl;
	@Value("${info.app.email}")
	private String appEmail;

	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("幸运派").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("cash.pai.lucky.web")).paths(PathSelectors.any()).build();
	}

	// 预览地址:swagger-ui.html
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring 中使用Swagger2构建文档").termsOfServiceUrl(appUrl)
				.contact(new Contact(appName, appUrl, appEmail)).version(appVersion).build();
	}
}
