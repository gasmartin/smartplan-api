package br.com.gsm.smartplan.smartplanapi;

import br.com.gsm.smartplan.smartplanapi.repository.TurmaRepository;
import java.net.InetAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartplanApiApplication {
    
    	private static final Logger log = LoggerFactory.getLogger(SmartplanApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SmartplanApiApplication.class, args);
	}
        
        @Bean
	public CommandLineRunner demo(TurmaRepository repository) {
		return (args) -> {
                      log.info("API iniciada com sucesso! Pode relaxar, Gabriel");
                      
                      String ip = InetAddress.getLocalHost().getHostAddress();
                      log.info("IP do servidor: " + ip);
		};
	}
}
