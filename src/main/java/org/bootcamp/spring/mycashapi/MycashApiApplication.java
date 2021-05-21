package org.bootcamp.spring.mycashapi;

import org.bootcamp.spring.mycashapi.service.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MycashApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MycashApiApplication.class, args);

		UsuarioService service = context.getBean(UsuarioService.class);
		service.criaUsuarioAdmin("admin@mycash.com", "admin");
		service.criaUsuarioUser("user@mycash.com", "user");
	}

}
