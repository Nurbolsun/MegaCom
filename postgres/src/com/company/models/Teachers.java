package com.company.models;

public class Teachers {
    private long id;
    private  String name;

    public Teachers( String name) {
        this.name = name;
    }

    public Teachers() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
