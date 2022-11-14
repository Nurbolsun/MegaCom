import service.DataBAseService;
import service.MainService;
import service.impl.DataBAseServiceImpl;
import service.impl.MainServiceImpl;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        DataBAseService dataBAseService = new DataBAseServiceImpl();

        MainService mainService = new MainServiceImpl();
        mainService.test(3);

    }
}