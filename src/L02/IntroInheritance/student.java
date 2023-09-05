package L02.IntroInheritance;

public class student {

    String name;
    String lastName;
    int age;

    Grade[] grades;


    public student(String name, String lastName, int age, Grade[] grades) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.grades = grades;
    }

    public student(student other) {
        this.name = other.name;
        this.lastName = other.lastName;
        this.age = other.age;
        int sizeGrade = other.grades.length;
        this.grades = new Grade[sizeGrade];
        for (int i = 0; i < sizeGrade; i++) {
            this.grades[i] = new Grade(other.grades[i]);
        }
    }

    void print() {

        System.out.println(this.name);
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", LastName='" + lastName + '\'' +
                ", age=" + age +
                '}' + super.toString();
    }
}

class Grade {
    String cName;
    String cNumber;

    int grade;

    public Grade(String cName, String cNumber, int grade) {
        this.cName = cName;
        this.cNumber = cNumber;
        this.grade = grade;
    }

    public Grade(Grade other) {
        this.cName = other.cName;
        this.cNumber = other.cNumber;
        this.grade = other.grade;
    }
}

class Test1 {


    public static void main(String[] args) {
        student s = new student("Barak", "Sharabi", 10, new Grade[10]);
        System.out.println(s);
        // p1
        // student s1 = s;
        //p2                     non-ref, non-ref,   non-ref,  ref
        //   student s1 = new student(s.name, s.lastName, s.age, s.grades);
        //p3                     non-ref, non-ref,   non-ref,  ref
        //    student s1 = new student(s.name, s.lastName, s.age, Arrays.copyOf(s.grades,10));

//        Grade[] temp = new Grade[s.grades.length];
//        for (int i = 0; i < temp.length; i++) {
//            temp[i]= new Grade(s.grades[i].cName,s.grades[i].cNumber,s.grades[i].grade);
//        }
//        student s1 = new student(s.name,s.lastName,s.age,temp);

//        student s1 = new student(s);
//        System.out.println(s1);


        student s3 = new student("", "", 15, new Grade[10]);
        student s4 = new student("4", "4", 14, new Grade[10]);

        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        s3.print();

    }
}