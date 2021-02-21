package com.compassouol.produtos.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//configurações da ferramenta de documentação swagger
@Configuration
public class SwaggerConfigurations {
	
	@Bean
	public Docket produtosApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.compassouol.produtos"))
				.paths(PathSelectors.ant("/**"))
				.build();
	}
}
