package es.urjc.code.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.urjc.code.dtos.AutonomicCommunityAggregateDto;
import es.urjc.code.models.Provincia;
import es.urjc.code.repository.ProvinceRepository;

@Service
public class MongoQueryRunner {

    private ProvinceRepository provinceRepository;

    public MongoQueryRunner(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;

    }

    public void run() {
        System.out.println("=========================================== QUERING MONGO ===========================================");

        this.query1();
        this.query2();

        System.out.println("=========================================== STOP QUERING ===========================================");
    }

    private void query1() {
        System.out.println("=========================================== MONGO QUERY 1 ===========================================");
        System.out.println("Listado de los datos de todas las provincias.\n");

        List<Provincia> provincias = provinceRepository.findAll();
        for (Provincia provincia : provincias) {
            System.out.println(provincia);
        }
    }

    private void query2() {
        System.out.println("=========================================== MONGO QUERY 2 ===========================================");
        System.out.println("Listado mostrando, para cada comunidad autónoma, su número de provincias\n"
        + "(Ceuta y Melilla se consideran como parte de la comunidad autónoma “sin comunidad”).\n");

        List<AutonomicCommunityAggregateDto> foo = provinceRepository.aggregationQuery();
        for (AutonomicCommunityAggregateDto ca : foo) {
            System.out.println(ca);
        }
    }

}
