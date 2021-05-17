package com.treeunfe.empresasteste.model;

import com.treeunfe.empresasteste.contract.LoginContract;
import com.treeunfe.empresasteste.entity.LoginHeaders;
import com.treeunfe.empresasteste.entity.User;
import com.treeunfe.empresasteste.repository.MemoryRepository;

public class LoginModel implements LoginContract.Model {

    private MemoryRepository memoryRepository;

    public LoginModel(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public void saveUser(User user) {
        memoryRepository.saveUser(user);
    }

    @Override
    public void saveLoginHeaders(LoginHeaders loginHeaders) {
        memoryRepository.saveLoginHeaders(loginHeaders);
    }
}
