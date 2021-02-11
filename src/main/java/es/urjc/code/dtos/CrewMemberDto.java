package es.urjc.code.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewMemberDto {
    private String name;
    private String lastName;
    private String originCity;
    private Date date;

    public String toString(){
        return
          "-----Depatyre cities and dates of a given Crew Member-----" +
              "\n##### Crew Member #####" +
              "\nName='" + name + "'" +
              "\nLast name='" + lastName + "'" +
              "\nDeparture city='" + originCity + "'" +
              "\nDate='" + date.toString() + "\n";
      };
}
