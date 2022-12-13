package com.ecommerce.natureba.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springNaturebaOpenAPI() {
		return new OpenAPI()
				.info(new Info()
				        .title("Projeto Natureba")
				        .description("Projeto Matureba - Generation Brasil")
				        .version("v0.0.1")
				        .license(new License()
				                .name("NeoCamp-MLB")
				                .url("http://brazil.generation.org/"))
				        .contact(new Contact()
				                .name("Grupo-1 | Silvio Julio | Willian Caetano | Brenda Bispo | Fred Alex | Vânia Gomes | Adriana Nogueira")
				                .url("https://github.com/Projeto-Integrador-Grupo-1")
				                .email("willian.caetano@mercacolivre.com/nsilvio.dossantoss@mercacolivre.com/nadriana.nogueira@mercacolivre.com/nbrenda.abispo@mercadolivre.com/nfred.abarros@mercadolivre.com/nvania.vgomes@mercadolivre.com/n")))
				.externalDocs(new ExternalDocumentation()
				        .description("Github")
				        .url("https://github.com/Projeto-Integrador-Grupo-1/natureba"));
				
	}

	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}
	
}
