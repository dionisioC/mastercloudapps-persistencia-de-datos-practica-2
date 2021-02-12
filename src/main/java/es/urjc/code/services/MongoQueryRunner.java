package es.urjc.code.services;

import es.urjc.code.models.Provincia;
import es.urjc.code.repository.ProvinceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoQueryRunner {

    private ProvinceRepository provinceRepository;

    public MongoQueryRunner(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;

    }

    public void run() {
        System.out.println("=========================================== QUERING MONGO ===========================================");

        this.query1();

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


}
