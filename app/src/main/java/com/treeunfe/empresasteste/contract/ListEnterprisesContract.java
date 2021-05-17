package com.treeunfe.empresasteste.contract;

import com.treeunfe.empresasteste.entity.Enterprise;
import com.treeunfe.empresasteste.entity.Enterprises;
import com.treeunfe.empresasteste.entity.LoginHeaders;

public interface ListEnterprisesContract {
    interface Model {
        LoginHeaders getLoginHeaders();

        void saveSelectedEnterprise(Enterprise enterprise);
    }

    interface View {
        void showProgress();

        void hideProgress();

        void showToast(String message);

        void showToast(int message);

        void updateRecyclerView(Enterprises enterprises);

        void openDetailsEnterprise();
    }

    interface Presenter {
        void searchEnterprises(String s);

        void clickItemEnterprise(Enterprise enterprise);
    }
}
