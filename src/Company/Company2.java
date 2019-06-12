package Company;

import java.util.*;

class EmployeeList{
    List<String> employees;

    public EmployeeList(){
        employees = new ArrayList<>();
    }

    public void addEmployee(String employee){
        if(!employees.contains(employee))
            employees.add(employee);
    }

    public int employeesCount(){
        return employees.size();
    }
}

class Pair{
    String manager;
    String employee;

    Pair(String input){
        String[] parts = input.split("\\s+");
        this.manager = parts[0];
        this.employee = parts[1];
    }

    String getManager(){
        return manager;
    }

    String getEmployee(){
        return employee;
    }
}

public class Company2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String,EmployeeList> tabela = new HashMap<>();

        while (input.hasNextLine()){
            String line = input.nextLine();
            Pair pair = new Pair(line);

            tabela.computeIfPresent(pair.getManager(),(manager,employees) -> {
                employees.addEmployee(pair.getEmployee());
                return employees;
            });

            tabela.computeIfAbsent(pair.getManager() , (k) -> new EmployeeList());
        }

        for(String key : tabela.keySet()){
            System.out.println(key + ": " + tabela.get(key).employeesCount());
        }


    }
}
