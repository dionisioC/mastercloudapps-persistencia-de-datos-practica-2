package es.urjc.code.controllers;

import es.urjc.code.services.DatabaseLoader;
import es.urjc.code.services.DatabaseQueryRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class AppBootstrap implements CommandLineRunner {

    private DatabaseLoader databaseLoader;
    private DatabaseQueryRunner databaseQueryRunner;

    public AppBootstrap(DatabaseLoader databaseLoader, DatabaseQueryRunner databaseQueryRunner) {
        this.databaseLoader = databaseLoader;
        this.databaseQueryRunner = databaseQueryRunner;
    }

    @Override
    public void run(String... args) throws Exception {
        this.databaseLoader.load();
        this.databaseQueryRunner.run();
    }
}
