package com.treeunfe.empresasteste.contract;

import com.treeunfe.empresasteste.entity.Enterprise;

public interface DetailsEnterpriseContract {
    interface Model {
        Enterprise getSelectedEnterprise();
    }

    interface View {
        void showEnterprise(Enterprise enterprise);
    }

    interface Presenter {
        void loadDetails();
    }
}
