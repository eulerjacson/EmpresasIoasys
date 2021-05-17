package com.treeunfe.empresasteste.entity;

public class Investor {
    private float id;
    private String investor_name;
    private String email;
    private String city;
    private String country;
    private float balance;
    private float portfolio_value;
    private boolean first_access;
    private boolean super_angel;

    // Getter Methods
    public float getId() {
        return id;
    }

    public String getInvestor_name() {
        return investor_name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public float getBalance() {
        return balance;
    }

    public float getPortfolio_value() {
        return portfolio_value;
    }

    public boolean getFirst_access() {
        return first_access;
    }

    public boolean getSuper_angel() {
        return super_angel;
    }

    // Setter Methods
    public void setId(float id) {
        this.id = id;
    }

    public void setInvestor_name(String investor_name) {
        this.investor_name = investor_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setPortfolio_value(float portfolio_value) {
        this.portfolio_value = portfolio_value;
    }

    public void setFirst_access(boolean first_access) {
        this.first_access = first_access;
    }

    public void setSuper_angel(boolean super_angel) {
        this.super_angel = super_angel;
    }
}
