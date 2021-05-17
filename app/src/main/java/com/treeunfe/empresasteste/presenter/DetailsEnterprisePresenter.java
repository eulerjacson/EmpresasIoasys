package com.treeunfe.empresasteste.presenter;

import com.treeunfe.empresasteste.contract.DetailsEnterpriseContract;
import com.treeunfe.empresasteste.entity.Enterprise;
import com.treeunfe.empresasteste.model.DetailsEnterpriseModel;
import com.treeunfe.empresasteste.util.MUtils;

public class DetailsEnterprisePresenter implements DetailsEnterpriseContract.Presenter {

    private DetailsEnterpriseContract.Model model;
    private DetailsEnterpriseContract.View view;

    public DetailsEnterprisePresenter(DetailsEnterpriseContract.View view) {
        this.view = view;
        this.model = new DetailsEnterpriseModel(MUtils.getMemoryRepository());
    }

    @Override
    public void loadDetails() {
        Enterprise enterprise = model.getSelectedEnterprise();
        view.showEnterprise(enterprise);
    }
}
