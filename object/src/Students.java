public class Students {
    String firstName, lastName, courseName, payment;
    int age;

    public Students (String firstName, String lastName, String courseName, String payment, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
        this.payment = payment;
        this.age = age;

    }

    void preview (){
        System.out.println("Name:" + firstName +" LastName:" + lastName +
                " CourseName:" + courseName + " Pay:" + payment + " Age:" +age);

        if (age <=23 && age >=18){
            System.out.println("Студентов возраст которых между 18-23: " + firstName);
        }

        if (payment.equals("yes")){
            System.out.println("Paid Course: " + firstName);
        }
    }

}
