package com.company;

public class CEO extends Employee{
    public boolean hasCompanyCar;
    public String ceo = "CEO";

    public  void  goPublic(){
        System.out.println("I am writing my awesome algoritm!");
    }

    public boolean isHasCompanyCar() {
        return hasCompanyCar;
    }

    public void setHasCompanyCar(boolean hasCompanyCar) {
        this.hasCompanyCar = hasCompanyCar;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }
}
