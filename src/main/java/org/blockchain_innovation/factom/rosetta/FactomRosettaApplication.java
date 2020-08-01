package org.blockchain_innovation.factom.rosetta;

import org.blockchain_innovation.factom.client.spring.FactomConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
@Import(FactomConfiguration.class)
@ComponentScan(basePackages = {"org.blockchain_innovation.factom.client", "org.blockchain_innovation.factom.rosetta", "org.blockchain_innovation.factom.rosetta.api", "org.blockchain_innovation.factom.rosetta.configuration"})
public class FactomRosettaApplication implements CommandLineRunner {

    @Override
    public void run(String... arg0) {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) {
        new SpringApplication(FactomRosettaApplication.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
