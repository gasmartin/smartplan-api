package br.com.gsm.smartplan.smartplanapi;

import br.com.gsm.smartplan.smartplanapi.model.Professor;
import br.com.gsm.smartplan.smartplanapi.model.Turma;
import br.com.gsm.smartplan.smartplanapi.repository.ProfessorRepository;
import br.com.gsm.smartplan.smartplanapi.repository.TurmaRepository;
import java.net.InetAddress;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartplanApiApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SmartplanApiApplication.class);
    
    @Autowired
    private ProfessorRepository professorRepository;

    public static void main(String[] args) {
        SpringApplication.run(SmartplanApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("API iniciada com sucesso! Pode relaxar, Gabriel");

        String ip = InetAddress.getLocalHost().getHostAddress();
        log.info("IP do servidor: " + ip);
    }
}
