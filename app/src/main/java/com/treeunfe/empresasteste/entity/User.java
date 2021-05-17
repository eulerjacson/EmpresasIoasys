package com.treeunfe.empresasteste.entity;

public class User {
    Investor InvestorObject;
    private boolean success;

    // Getter Methods
    public Investor getInvestor() {
        return InvestorObject;
    }

    public boolean getSuccess() {
        return success;
    }

    // Setter Methods
    public void setInvestor(Investor investorObject) {
        this.InvestorObject = investorObject;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
