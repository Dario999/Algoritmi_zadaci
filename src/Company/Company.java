package Company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CompanyPair {
    String manager;
    String employee;

    CompanyPair(String input) {
        String [] parts = input.split("\\s+");
        this.manager = parts[0];
        this.employee = parts[1];
    }

    String getManager() {
        return manager;
    }

    String getEmployee() {
        return employee;
    }
}

public class Company {

    private static Map<String, List<String>> employeeMap = new HashMap<>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.lines()
                .map(CompanyPair::new)
                .forEach(pair -> {
                    employeeMap.computeIfPresent(pair.getManager(), (k,v)-> {
                        if (!v.contains(pair.getEmployee()))
                            v.add(pair.getEmployee());
                        return v;
                    });
                    employeeMap.computeIfAbsent(pair.getManager(),(k)-> new ArrayList<>());
                });



        employeeMap.entrySet()
                .stream()
                .map(entry -> entry.getKey()+ ": " + entry.getValue().size())
                .forEach(System.out::println);

    }

}