package service.impl;

import service.DataBAseService;
import service.MainService;

import java.util.*;

public class MainServiceImpl implements MainService {
    DataBAseService dataBAseService = new DataBAseServiceImpl();

    @Override
    public void test(int countOfQuetions) {
        dataBAseService.getAllCountries();
        Scanner scanner = new Scanner(System.in);
        int countOfCorrect=0;
        int questionNum = 1;

        for (int i = 0; i < countOfQuetions; i++) {
            HashMap<String, HashMap<String, Boolean>> params = dataBAseService.getQuetion();
            for (Map.Entry<String, HashMap<String, Boolean>> iteam: params.entrySet()){
                System.out.println("Номер вопроса " + questionNum);
                questionNum++;
                System.out.println("Страна " + iteam.getKey());

                ArrayList<String> cities = new ArrayList<>();
                for (Map.Entry<String,Boolean> option: iteam.getValue().entrySet()){
                    cities.add(option.getKey());
                }
                Collections.shuffle(cities);
                int cityNum = 1;
                for (String city: cities){
                    System.out.println(cityNum + ":" + city);
                    cityNum++;
                }
                System.out.println("Выберите номер ответа ");
                int answer = scanner.nextInt();
                if (iteam.getValue().get(cities.get(answer-1))){
                    countOfCorrect++;
                }
            }
        }

    }
}
