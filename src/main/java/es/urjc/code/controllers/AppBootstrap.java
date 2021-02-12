package es.urjc.code.controllers;

import es.urjc.code.services.DatabaseQueryRunner;
import es.urjc.code.services.MongoQueryRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class AppBootstrap implements CommandLineRunner {

    private DatabaseQueryRunner databaseQueryRunner;
    private MongoQueryRunner mongoQueryRunner;

    public AppBootstrap(DatabaseQueryRunner databaseQueryRunner, MongoQueryRunner mongoQueryRunner) {
        this.databaseQueryRunner = databaseQueryRunner;
        this.mongoQueryRunner = mongoQueryRunner;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.databaseQueryRunner.run();
        this.mongoQueryRunner.run();
    }
}
