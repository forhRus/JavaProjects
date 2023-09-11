package Base;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee{
    private static String _type = "Рабочий";

    private Worker(String surName, String name, double salary){
        super(_type, surName, name);
        this.setSalary(salary);
        //System.out.println("Constructor - Worker");
    }

    public static Employee getInstance(){
        return new Worker(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(30000, 250000));
    }

    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }




}
