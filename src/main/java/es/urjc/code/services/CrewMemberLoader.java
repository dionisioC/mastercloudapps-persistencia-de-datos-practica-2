package es.urjc.code.services;

import es.urjc.code.models.*;
import es.urjc.code.repository.CrewMemberRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CrewMemberLoader {

    private CrewMemberRepository crewMemberRepository;

    public CrewMemberLoader(CrewMemberRepository crewMemberRepository) {
        this.crewMemberRepository = crewMemberRepository;
    }

    public List<CrewMember> load() {
        System.out.println("=========================================== LOADING CREW MEMBERS ===========================================");
        List<CrewMember> crewMembers = Arrays.asList(
            CrewMember.builder().code("code01").name("John").lastName("Doe").role("Flight attendant").companyName("Iberia").build(),
            CrewMember.builder().code("codeRed").name("Manfred Albrecht").lastName("von Richthofen").role("Piloto").companyName("Iberia").build(),
            CrewMember.builder().code("codeLaugh").name("Alfonso").lastName("Aragón Sac").role("Fun guy").companyName("Ryanair").build(),
            CrewMember.builder().code("codeFam").name("Spike").lastName("Lee").role("Unimportant famous").companyName("United Airlines").build()

           );
        System.out.println("=========================================== FINISH LOADING CREW MEMBERS ===========================================");
        return crewMembers;
    }

}
