package com.oraclealura.Literatura;

import com.oraclealura.Literatura.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication  implements CommandLineRunner {

	@Autowired
	private Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			if (principal != null) {
				principal.mostrarMenu();
			} else {
				System.out.println("Principal no está inicializado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
