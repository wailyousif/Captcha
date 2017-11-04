package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;


@EnableSwagger2
@SpringBootApplication
@EnableScheduling
public class SpringJpaWebApplication {


	public static void main(String[] args)
	{
		SpringApplication.run(SpringJpaWebApplication.class, args);
	}

	@Bean
	public Docket mainApis() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("app-apis")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/rest/bp/*.*"))
				.build()
				.globalOperationParameters(
						newArrayList(new ParameterBuilder()
								.name("x-authorization-key")
								.description("API Authorization Key")
								.modelRef(new ModelRef("string"))
								.parameterType("header")
								.required(false)
								.build()));

	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Sadad APIs")
				.description("Sadad")
				.termsOfServiceUrl("http://localhost:8080/mvc/license/terms")
				.contact("Wail Yousif")
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
				.version("2.1")
				.build();
	}
}
