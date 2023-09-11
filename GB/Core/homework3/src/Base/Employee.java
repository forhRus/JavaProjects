package Base;

import java.util.Random;

public abstract class Employee implements Comparable<Employee>{

    //region Public Methods

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.getSalary());
        //return calculateSalary() == o.calculateSalary() ? 0 :
        //        calculateSalary() > o.calculateSalary() ? 1 : -1;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s; Среднемесячная заработная плата: %.2f (руб.)",
                surName, name, type, salary);
    }

    //endregion

    //region Constructors And Initializers

    {
        //System.out.println("Initialize - Employee");
        id = ++counter;
    }

    protected Employee(String type, String surName, String name){
        this(type, surName, name, 0);
    }

    protected Employee(String type, String surName, String name, double salary){
        //System.out.println("Constructor - Employee");
        this.type = type;
        this.surName = surName;
        this.name = name;
        this.salary = salary;
    }

    //endregion

    //region Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 30000){
            throw new RuntimeException("Уровень заработной платы должен быть не менее 30000");
        }
        this.salary = salary;
    }

    public String getType() {
        return type;
    }
    //endregion

    //region Fields

    private int id;
    /**
     * Тип найма
     */
    protected String type;

    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;

    /**
     * Заработной платы
     */
    protected double salary;

    //endregion

    //region Static Fields

    protected static String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    protected static String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
    protected static Random random = new Random();
    private static int counter = 1000;

    //endregion

}
