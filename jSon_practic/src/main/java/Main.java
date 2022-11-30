import com.google.gson.Gson;
import microservices.OkHttoConnection;
import models.Employee;
import models.Hobby;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.parser.TokenType.XML;

public class Main {
    public static void main(String[] args) {

//        UserService userService = new UserServiceImpl();
//        System.out.println(userService);

        Employee employee = new Employee();

        OkHttoConnection connection = new OkHttoConnection();
        String response = connection.getJson();

        JSONObject jsonObject = XML.toJSONObject(response);
        Gson gson = new Gson();

        Employee[] employees = gson.fromJson(response, Employee[].class);
        Arrays.stream(employees);





        System.out.println("F1 " + employees);
        System.out.println("F2 "+employeeList2);


    }
}
