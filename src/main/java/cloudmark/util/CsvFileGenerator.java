package cloudmark.util;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import cloudmark.entity.Employee;


@Component
public class CsvFileGenerator {
    public void writeEmployeeToCsv(List<Employee> employees, Writer writer) {
        try {
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
            printer.printRecord("id","firstName","lastName","address","cap","city","iban","phoneNumber","email","contractType","contractStart");
            for (Employee employee : employees) {
                printer.printRecord(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getAddress(),
                        employee.getCap(),
                        employee.getCity(),
                        employee.getIban(),
                        employee.getPhoneNumber(),
                        employee.getEmail(),
                        employee.getContractType(),
                        employee.getContractStart()
                        );
            }
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}