package L05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Organization {
    static Random rd = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN  = "\u001B[32m";


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
                ANSI_RED + "marketing=" + ANSI_RESET + Arrays.toString(marketing) +
                ANSI_GREEN +  ", engineering=" + ANSI_RESET +Arrays.toString(engineering) +
                ANSI_YELLOW +", managers=" + ANSI_RESET + Arrays.toString(managers) +
                ANSI_PURPLE +", ceo=" + ceo +
                '}'+ANSI_RESET ;
    }

    static class Test {

        public static void main(String[] args) {
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
            CEO ceo = new CEO("Barak", "123456789", 50000.0);
            int employeeToCreate = 4;
            for (int i = 0; i < 2; i++) {
                String id = "" + rd.nextInt(999999999) + 100000000;
                managers[i] = new Manager("name-" + i + rd.nextInt(100) + 50, id, (rd.nextDouble(50000) + 20000));

                for (int j = 0; j < employeeToCreate; j++) {
                    if (employeeToCreate == 4)
                        managers[i].addWorker(marketing[j]);
                    else
                        managers[i].addWorker(engineering[j]);
                }
                employeeToCreate++;
                ceo.addManager(managers[i]);
            }

            Organization organization = new Organization(marketing, engineering, managers, ceo);
            System.out.println(organization);
        }

    }


    static class Worker {
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
            return ANSI_BLUE + "Worker{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", salary=" + salary +
                    '}' + ANSI_RESET;
        }
    }

    static class Manager extends Worker {

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
            return ANSI_YELLOW + "Manager{" +
                    ANSI_CYAN +   "employee=" + employee +
                    "}\n" + ANSI_RESET;
        }
    }

    static class CEO extends Manager {

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
            return ANSI_PURPLE + "CEO{" +
                    ANSI_YELLOW+ "managers=" + managers +
                    "}\n" + ANSI_RESET;
        }
    }

}
