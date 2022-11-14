package com.company.db.impl;

import com.company.db.DBHelper;
import com.company.models.Teachers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelperImpl implements DBHelper {
    @Override
    public void createTeacher(Teachers teachers) {


            PreparedStatement ps = null;
        try {
            ps = getConnection("insert into tb_teachers(name) values (?)");
            ps.setString(1, teachers.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw  new RuntimeException("Произошла ошибка при сохранении преподавателя");
        }

    }

    @Override
    public Teachers getById(long id) {
        try {
            PreparedStatement ps = getConnection("select * from tb_teachers where id=?");
            ps.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = ps.executeQuery();
            Teachers teachers = new Teachers();
            while (resultSet.next()){
                teachers.setId(resultSet.getLong("id"));
                teachers.setName(resultSet.getString("name"));
            }
            return teachers;

        } catch (SQLException e) {
            throw new RuntimeException("Произошло ошибка при выводе ");
        }
    }

    @Override
    public List<Teachers> getAll() {
        try {
            PreparedStatement ps = getConnection("select * from tb_teachers");
            ResultSet resultSet = ps.executeQuery();
            List<Teachers> teacherses = new ArrayList<>();
            while (resultSet.next()){
                Teachers teachers = new Teachers();
                teachers.setId(resultSet.getLong("id"));
                teachers.setName(resultSet.getString("name"));
                teacherses.add(teachers);
            }
            return teacherses;
        } catch (SQLException throwables) {
            throw  new RuntimeException("Произошло ошибка при выводе списка");
        }
    }

    @Override
    public void updateTeacher(long id) {

    }

    @Override
    public void deleteTeacher(long id) {
        try {

            PreparedStatement ps = getConnection("delete from tb_teachers where id=?");
            ps.setInt(1, Math.toIntExact(id));
            int result = ps.executeUpdate();
            if (result==1){
                System.out.println("Обьект успешно удален");
            }else if (result==0){
                System.out.println("Обьект не удален");
            }

        } catch (SQLException throwables) {
            throw  new RuntimeException("Произошло ошибка при удаление");
        }

    }

    private PreparedStatement  getConnection(String sql){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\НУР\\GitHub\\SQL\\itschool.db");
            PreparedStatement ps = connection.prepareStatement(sql);
            return ps;
        } catch (SQLException e) {
            throw new RuntimeException("Ощибка при подключение БД");
        }
    }
}
