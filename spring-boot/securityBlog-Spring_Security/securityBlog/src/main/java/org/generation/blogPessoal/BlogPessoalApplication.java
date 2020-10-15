package org.generation.blogPessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogPessoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogPessoalApplication.class, args);
		
		//criptografia da palavra teste(aparecerá no console)
		System.out.print(new BCryptPasswordEncoder().encode("teste"));

	}

}
