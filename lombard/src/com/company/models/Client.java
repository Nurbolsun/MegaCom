package com.company.models;

public class Client {
    private double id;
    private String idCard;
    private boolean blocked;
    private String name;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", idCard='" + idCard + '\'' +
                ", blocked=" + blocked +
                ", name='" + name + '\'' +
                '}';
    }

    public double getId() {
        return id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
