package es.urjc.code.services;

import es.urjc.code.models.MechanicalEmployee;
import es.urjc.code.repository.MechanicalEmployeeRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class MechanicalEmployeeLoader {

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    private Date pedroDate;
    private Date pabloDate;
    private Date vilmaDate;
    private Date bettyDate;

    private MechanicalEmployeeRepository mechanicalEmployeeRepository;

    public MechanicalEmployeeLoader(MechanicalEmployeeRepository mechanicalEmployeeRepository) {
        this.mechanicalEmployeeRepository = mechanicalEmployeeRepository;
        try {
            this.pedroDate = dateFormatter.parse("1998-05-09");
            this.pabloDate = dateFormatter.parse("2000-06-10");
            this.vilmaDate = dateFormatter.parse("2002-08-12");
            this.bettyDate = dateFormatter.parse("2004-12-16");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<MechanicalEmployee> load() {
        System.out.println("=========================================== LOADING MECHANICAL EMPLOYEES ===========================================");
        List<MechanicalEmployee> mechanicalEmployees = Arrays.asList(
            MechanicalEmployee.builder().code("EmployeeCodePP").name("Pedro").lastName("Picapiedra").companyName("URJC").education("Universidad").startingDate(pedroDate).build(),
            MechanicalEmployee.builder().code("EmployeeCodePM").name("Pablo").lastName("Marmol").companyName("UPM").education("Doctorado").startingDate(pabloDate).build(),
            MechanicalEmployee.builder().code("EmployeeCodeVP").name("Vilma").lastName("Picapiedra").companyName("UAM").education("Master").startingDate(vilmaDate).build(),
            MechanicalEmployee.builder().code("EmployeeCodeBM").name("Betty").lastName("Marmol").companyName("UAH").education("Grado superior").startingDate(bettyDate).build()
        );
        mechanicalEmployeeRepository.saveAll(mechanicalEmployees);
        System.out.println("=========================================== FINISH LOADING MECHANICAL EMPLOYEES ===========================================");
        return mechanicalEmployees;
    }

}
