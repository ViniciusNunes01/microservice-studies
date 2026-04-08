package io.github.viniciusnunes01.microservice_studies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				title = "API MICROSERVICE STUDIES TAC",
				version = "1.0.1",
				contact = @Contact(name = "Vinicius Nunes", email = "viniciusn@alunos.utfpr.edu.br"),
				description = "API da disciplina TAC...",
				summary = "API bagual!",
				license = @License(name = "Qualquer", url = "http://...")
				),
		servers = {
				@Server(url = "http://localhost:8080", description = "Testes locais"),
				@Server(url = "http://myapp.com", description = "Produção")
		})
@SpringBootApplication
public class MicroserviceStudiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceStudiesApplication.class, args);
	}

}
