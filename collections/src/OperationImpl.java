import java.util.*;

public class OperationImpl implements Operation {
    @Override
    public void getInfoAge() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Aman", 18));
        employees.add(new Employee("Turat", 15));
        employees.add(new Employee("Bek", 21));
        employees.add(new Employee("Esen", 32));
        employees.add(new Employee("Adilet", 19));



        Collections.sort(employees, new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
//               int comp = e1.getName().compareTo(e2.getName());
//                if (comp != 0) {
//                    return comp;
//                }
                    return e1.getAge() - e2.getAge();
                }
        });
        System.out.println(employees);
    }

}