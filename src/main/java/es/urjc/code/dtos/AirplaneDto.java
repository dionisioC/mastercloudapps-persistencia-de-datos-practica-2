package es.urjc.code.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDto {

    private long id;
    private String mechanicalEmployeeName;
    private String mechanicalEmployeeLastName;
    private String licensePlate;
    private String manufacturer;
    private String model;
    private BigDecimal flightHours;

    @Override
    public String toString() {
        return
            "------Airplane Revision-------" +
                "\n###### Mechanical Employee ######\n" +
                "\tName='" + mechanicalEmployeeName + "'\n" +
                "\tLast Name='" + mechanicalEmployeeLastName + "'\n" +
                "\n****** Plane ******\n" +
                "\tLicense Plate='" + licensePlate + "'\n" +
                "\tManufacturer='" + manufacturer + "'\n" +
                "\tModel='" + model + "'\n" +
                "\tFlight Hours=" + flightHours;
    }
}
