package es.urjc.code.controllers;

import es.urjc.code.services.DatabaseQueryRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class AppBootstrap implements CommandLineRunner {

    private DatabaseQueryRunner databaseQueryRunner;

    public AppBootstrap(DatabaseQueryRunner databaseQueryRunner) {
        this.databaseQueryRunner = databaseQueryRunner;
    }

    @Override
    public void run(String... args) throws Exception {
        this.databaseQueryRunner.run();
    }
}
