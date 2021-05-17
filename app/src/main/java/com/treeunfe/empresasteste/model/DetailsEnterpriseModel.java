package com.treeunfe.empresasteste.model;

import com.treeunfe.empresasteste.contract.DetailsEnterpriseContract;
import com.treeunfe.empresasteste.entity.Enterprise;
import com.treeunfe.empresasteste.repository.MemoryRepository;

public class DetailsEnterpriseModel implements DetailsEnterpriseContract.Model {

    private MemoryRepository memoryRepository;

    public DetailsEnterpriseModel(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public Enterprise getSelectedEnterprise() {
        return memoryRepository.getEnterprise();
    }
}
