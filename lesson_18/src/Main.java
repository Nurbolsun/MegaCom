import classroom.Dog;
import task.Employee;
import task.Specialist;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee();

        Specialist specialist = new Specialist();

        specialist.setLevels(5);
        specialist.setAge(5);

        System.out.println(specialist.getAge());


    }
}