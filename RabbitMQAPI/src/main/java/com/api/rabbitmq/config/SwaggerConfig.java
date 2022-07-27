package com.api.rabbitmq.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket swagger(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.api.rabbitmq"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo());
	}

	@SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("RabbitMQ API", 
									  "API para testes de criação de filas e mensagens no RabbitMQ",
									  "1.7", 
									  "Termos de Serviço", 
									  new Contact("Neiton Junior Carneiro", "https://github.com/neitonjc/", "neitonjc@gmail.com"), null, null, new ArrayList<VendorExtension>()
						);
		return apiInfo;
	}

}
