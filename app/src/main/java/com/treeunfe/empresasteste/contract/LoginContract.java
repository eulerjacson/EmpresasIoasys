package com.treeunfe.empresasteste.contract;

import com.treeunfe.empresasteste.entity.LoginHeaders;
import com.treeunfe.empresasteste.entity.User;

public interface LoginContract {
    interface Model {
        void saveUser(User user);

        void saveLoginHeaders(LoginHeaders loginHeaders);
    }

    interface View {
        String getEmail();

        String getPassword();

        void cleanFieldsErrors();

        void setError(String error);

        void showProgressDialog();

        void hideProgressDialog();

        void showToast(String message);

        void showToast(int message);

        void openEnterprises();
    }

    interface Presenter {
        void login();
    }
}
