package com.treeunfe.empresasteste.entity;

public class Enterprise {
    private Integer id;
    private String email_enterprise;
    private String facebook;
    private String twitter;
    private String linkedin;
    private String phone;
    private boolean own_enterprise;
    private String enterprise_name;
    private String photo;
    private String description;
    private String city;
    private String country;
    private float value;
    private float share_price;
    EnterpriseType enterprise_type;


    // Getter Methods

    public Integer getId() {
        return id;
    }

    public String getEmail_enterprise() {
        return email_enterprise;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getPhone() {
        return phone;
    }

    public boolean getOwn_enterprise() {
        return own_enterprise;
    }

    public String getEnterpriseName() {
        return enterprise_name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public float getValue() {
        return value;
    }

    public float getShare_price() {
        return share_price;
    }

    public EnterpriseType getEnterpriseType() {
        return enterprise_type;
    }

    // Setter Methods

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail_enterprise(String email_enterprise) {
        this.email_enterprise = email_enterprise;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOwn_enterprise(boolean own_enterprise) {
        this.own_enterprise = own_enterprise;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setShare_price(float share_price) {
        this.share_price = share_price;
    }

    public void setEnterprise_type(EnterpriseType enterprise_typeObject) {
        this.enterprise_type = enterprise_typeObject;
    }
}

