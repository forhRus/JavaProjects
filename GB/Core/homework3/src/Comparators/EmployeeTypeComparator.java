package Comparators;

import Base.Employee;

import java.util.Comparator;

public class EmployeeTypeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
