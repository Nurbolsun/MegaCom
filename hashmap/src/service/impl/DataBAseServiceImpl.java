package service.impl;

import service.DataBAseService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DataBAseServiceImpl implements DataBAseService {
        HashMap<String,String> data = new HashMap<>();
        ArrayList<String> countries =new ArrayList<>();
        ArrayList<String>  cities = new ArrayList<>();

    @Override
    public void getAllCountries() {

        data.put("������", "������");
        data.put("����������", "�������");
        data.put("����������", "������");
        data.put("�������", "����");
        data.put("�����", "�������");
        data.put("������", "�������");
        data.put("�����", "�����");
        data.put("�������", "�����");
        data.put("���", "���������");
        data.put("���������", "��������");
        data.put("�����", "�����");
        data.put("������", "������");
        data.put("������", "���");
        data.put("������", "�����");
        data.put("������", "�������");

        for (Map.Entry<String,String> iteam: data.entrySet()){
            countries.add(iteam.getKey());
            cities.add(iteam.getValue());
        }
        Collections.shuffle(countries);
        Collections.shuffle(cities);
    }

    @Override
    public HashMap getQuetion() {
        HashMap<String, HashMap<String,Boolean>> quetions = new HashMap<>();
        String country = countries.get(3);
        countries.remove(3);

        String city = data.get(country);
        HashMap<String, Boolean> options = new HashMap<>();

        options.put(city, true);

        Collections.shuffle(cities);

        for (int i = 0; i < 3; i++) {
            options.put(cities.get(i), false);
        }
        cities.add(city);
        quetions.put(country, options);
        Collections.shuffle(countries);
        return quetions;
    }
}
