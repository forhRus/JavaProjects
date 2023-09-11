package Base;

/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee {
    private static String _type = "Фрилансер";
    private double ratePerHour;


    public Freelancer(String surName, String name, double ratePerHour) {
        super(_type, surName, name);
        setRatePerHour(ratePerHour);
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 500){
            throw new RuntimeException("Ставка заработной платы должна быть не менее 500");
        }
        double salary = 20.8 * 8 * ratePerHour;
        this.setSalary(salary);
        this.ratePerHour = ratePerHour;
    }
    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(500, 1000));
    }


}
