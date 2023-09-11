package Base;

import java.util.*;

public class Staff implements Iterable<Employee>{

    //region Fields
    private List<Employee> _employees;
    //endregion

    //region Конструкторы
    public Staff(){
        this(new ArrayList<>());
    }

    public Staff(List<Employee> employees) {
        _employees = employees;
    }
    //endregion

    //region Getter & Setter
    public List<Employee> get_employees() {
        return _employees;
    }

    //endregion

    //region Methods
    public void add(Employee employee){
        _employees.add(employee);
    }
    public void sort(){
        Collections.sort(_employees);
    }
    public void sort(Comparator comporator){
        _employees.sort(comporator);
    }

    @Override
    public Iterator<Employee> iterator() {
        Iterator<Employee> it = new Iterator<Employee>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < _employees.size();
            }

            @Override
            public Employee next() {
                return _employees.get(index++);
            }
        };
        return it;
    }
    //endregion

}
