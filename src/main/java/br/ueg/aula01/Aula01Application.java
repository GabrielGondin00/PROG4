package br.ueg.aula01;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ueg.aula01.model.Tenis;
import br.ueg.aula01.repository.TenisRepository;

@SpringBootApplication
public class Aula01Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(TenisRepository repository) {
		return args -> {
          
		
		  
		  Tenis t1 = new Tenis (1L,"Air Max 90","Nike",39,"900,00");
          repository.save(t1);
          t1 = new Tenis (2L,"Jordan 4","Nike",42,"2.300,00");
       };
    }
}
