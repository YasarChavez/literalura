package com.yasarchavez.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yasarchavez.literalura.principal.Principal;
import com.yasarchavez.literalura.repository.AuthorRepository;
import com.yasarchavez.literalura.repository.BookRepository;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	AuthorRepository autorRepository;
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(autorRepository, bookRepository);
		principal.MuestraElMenu();
	}

}
