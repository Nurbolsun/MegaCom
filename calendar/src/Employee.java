public class Employee {
    public Employee(String name, String dateOfB) {
        this.name = name;
        this.dateOfB = dateOfB;
    }

    private String name;
    private  String dateOfB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfB() {
        return dateOfB;
    }

    public void setDateOfB(String dateOfB) {
        this.dateOfB = dateOfB;
    }
}
