package com.treeunfe.empresasteste.model;

import com.treeunfe.empresasteste.contract.ListEnterprisesContract;
import com.treeunfe.empresasteste.entity.Enterprise;
import com.treeunfe.empresasteste.entity.LoginHeaders;
import com.treeunfe.empresasteste.repository.MemoryRepository;

public class ListEnterprisesModel implements ListEnterprisesContract.Model {

    private MemoryRepository memoryRepository;

    public ListEnterprisesModel(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public LoginHeaders getLoginHeaders() {
        return memoryRepository.getLoginHeaders();
    }

    @Override
    public void saveSelectedEnterprise(Enterprise enterprise) {
        memoryRepository.saveSelectedEnterprise(enterprise);
    }
}
