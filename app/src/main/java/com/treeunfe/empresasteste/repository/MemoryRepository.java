package com.treeunfe.empresasteste.repository;

import com.treeunfe.empresasteste.entity.Enterprise;
import com.treeunfe.empresasteste.entity.LoginHeaders;
import com.treeunfe.empresasteste.entity.User;

public class MemoryRepository {

    private User user;
    private LoginHeaders loginHeaders;
    private Enterprise enterprise;

    public void saveUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void saveLoginHeaders(LoginHeaders loginHeaders) {
        this.loginHeaders = loginHeaders;
    }

    public LoginHeaders getLoginHeaders() {
        return loginHeaders;
    }

    public void saveSelectedEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }
}
