package com.galvanize.yellowsub;

public class Sandwich {
    private String bread;
    private String veggies [];
    private String meats [];
    private String condiments [];

    public Sandwich(String bread, String[] veggies, String[] meats, String[] condiments) {
        this.bread = bread;
        this.veggies = veggies;
        this.meats = meats;
        this.condiments = condiments;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String[] getVeggies() {
        return veggies;
    }

    public void setVeggies(String[] veggies) {
        this.veggies = veggies;
    }

    public String[] getMeats() {
        return meats;
    }

    public void setMeats(String[] meats) {
        this.meats = meats;
    }

    public String[] getCondiments() {
        return condiments;
    }

    public void setCondiments(String[] condiments) {
        this.condiments = condiments;
    }
}
