package com.company.db;

import com.company.models.Teachers;

import java.util.List;

public interface DBHelper {
    void createTeacher(Teachers teachers);

    Teachers getById(long id);

    List<Teachers> getAll();

    void updateTeacher(long id);

    void deleteTeacher(long id);

}
