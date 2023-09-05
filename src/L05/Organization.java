package L05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Test {

    static Random rd = new Random();

    public static void main(String[] args) {

        CEO ceo = new CEO("Barak", "123456789", 50000.0);
        Worker[] marketing = new Worker[4];
        Worker[] engineering = new Worker[5];
        Manager[] managers = new Manager[2];
        for (int i = 0; i < 4; i++) {
            String id = "" + rd.nextInt(999999999) + 100000000;
            marketing[i] = new Worker("name-" + i, id, (rd.nextDouble(50000) + 20000));
        }
        for (int i = 0; i < 5; i++) {
            String id = "" + rd.nextInt(999999999) + 100000000;
            engineering[i] = new Worker("name-" + i + rd.nextInt(100) + 50, id, (rd.nextDouble(50000) + 20000));
        }
        int employeeToCreate = 4;
        for (int i = 0; i < 2; i++) {
            String id = "" + rd.nextInt(999999999) + 100000000;
            managers[i] = new Manager("name-" + i + rd.nextInt(100) + 50, id, (rd.nextDouble(50000) + 20000));
            ceo.addManager(managers[i]);
            for (int j = 0; j < employeeToCreate; j++) {
                if (employeeToCreate == 4)
                    managers[i].addWorker(marketing[j]);
                else
                    managers[i].addWorker(engineering[j]);
            }
                employeeToCreate++;
        }

        Organization organization = new Organization(marketing, engineering, managers, ceo);
        System.out.println(organization);
    }

}

public class Organization {

    private Worker[] marketing;
    private Worker[] engineering;
    private Manager[] managers;
    private CEO ceo;


    public Organization(Worker[] marketing, Worker[] engineering, Manager[] managers, CEO ceo) {
        this.marketing = marketing;
        this.engineering = engineering;
        this.managers = managers;
        this.ceo = ceo;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "marketing=" + Arrays.toString(marketing)  +
                ", engineering=" + Arrays.toString(engineering) +
                ", managers=" + Arrays.toString(managers) +
                ", ceo=" + ceo +
                '}';
    }
}

class Worker {
    private String name;
    private String id;
    private Double salary;

    public Worker(String name, String id, Double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Worker(Worker worker) {
        this.name = worker.name;
        this.id = worker.id;
        this.salary = worker.salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Manager extends Worker {

    private ArrayList<Worker> employee;

    public Manager(String name, String id, Double salary) {
        super(name, id, salary);
        this.employee = new ArrayList<>();
    }

    public Manager(Manager manager) {
        super(manager);
        this.employee = new ArrayList<>();
        ArrayList<Worker> toCopyFromOtherManager = manager.employee;
        for (int i = 0; i < toCopyFromOtherManager.size(); i++) {
            Worker copy = new Worker(toCopyFromOtherManager.get(i));
            this.employee.add(copy);
        }
    }

    public boolean addWorker(Worker worker) {
        if (worker == null)
            return false;
        employee.add(worker);
        return true;
    }

    public Worker removeWorker(Worker worker) {
        if (worker == null)
            return null;
        employee.remove(worker);
        return worker;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employee=" + employee +
                "}\n" + super.toString();
    }
}

class CEO extends Manager {

    private ArrayList<Manager> managers;

    public CEO(String name, String id, Double salary) {
        super(name, id, salary);
        this.managers = new ArrayList<>();
    }

    public CEO(CEO ceo) {
        super(ceo);
        this.managers = new ArrayList<>();
        ArrayList<Manager> toCopyFromOtherCEO = ceo.managers;
        for (int i = 0; i < toCopyFromOtherCEO.size(); i++) {
            Manager copy = new Manager(toCopyFromOtherCEO.get(i));
            this.managers.add(copy);
        }
    }

    public boolean addManager(Manager manager) {
        if (manager == null)
            return false;
        this.managers.add(manager);
        return true;
    }

    public Manager removeManager(Manager manager) {
        if (manager == null)
            return null;
        this.managers.remove(manager);
        return manager;
    }

    @Override
    public String toString() {
        return "CEO{" +
                "managers=" + managers +
                "}\n" + super.toString();
    }
}


