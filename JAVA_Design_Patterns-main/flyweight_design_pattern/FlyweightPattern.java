package flyweight_design_pattern;

import java.util.HashMap;
import java.util.Random;


//Employee interface created
interface Employee {
    public void assignSkill(String skill);

    public void task();
}


class Developer implements Employee { //implementation of Employee for Developer

    private final String JOB;
    private String skill;

    public Developer() {
        JOB = "Fix the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    }

}

class Tester implements Employee {  //implementation of Employee for Tester
    private final String JOB;
    private String skill;

    public Tester() {
        JOB = "Test the issue";
    }

    //void methods
    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
    }

}

class EmployeeFactory {
    // HashMap to store created Employee instances based on their type.
    private static HashMap<String, Employee> m = new HashMap<String, Employee>();

    //getter method getEmployee
    public static Employee getEmployee(String type) {
        Employee p = null;
        if (m.get(type) != null) {
            p = m.get(type);
        } else {
            switch (type) {
                case "Developer":
                    //if type Developer print out
                    System.out.println("Developer Created");
                    p = new Developer();
                    break;
                case "Tester":
                    //if type Tester print out
                    System.out.println("Tester Created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("No Such Employee");
            }

            m.put(type, p);
        }
        return p;
    }
}

public class FlyweightPattern {
    //Create array
    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", ".Net", "Python"};

    public static void main(String[] args) {
        //use for loop to get Employee and assign skill and task
        for (int i = 0; i < 10; i++) {
            Employee e = EmployeeFactory.getEmployee(getRandEmployee());
            e.assignSkill(getRandSkill());
            e.task();
        }
    }

    //getter getRandEmployee
    public static String getRandEmployee() {
        Random r = new Random();
        int randInt = r.nextInt(employeeType.length);
        return employeeType[randInt];
    }

    //getter getRandSkill
    public static String getRandSkill() {
        Random r = new Random();
        int randInt = r.nextInt(skills.length);
        return skills[randInt];
    }
}