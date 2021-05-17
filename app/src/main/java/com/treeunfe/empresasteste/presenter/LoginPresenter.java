package com.treeunfe.empresasteste.presenter;

import androidx.annotation.NonNull;

import com.treeunfe.empresasteste.R;
import com.treeunfe.empresasteste.api.SettingsAPI;
import com.treeunfe.empresasteste.contract.LoginContract;
import com.treeunfe.empresasteste.entity.LoginHeaders;
import com.treeunfe.empresasteste.entity.User;
import com.treeunfe.empresasteste.model.LoginModel;
import com.treeunfe.empresasteste.util.MUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.Model model;
    private LoginContract.View view;
    private SettingsAPI settingsAPI;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.model = new LoginModel(MUtils.getMemoryRepository());
        this.settingsAPI = SettingsAPI.getInstance();
    }

    @Override
    public void login() {
        Call<User> request = settingsAPI.getAPI().login(view.getEmail(), view.getPassword());

        view.showProgressDialog();
        request.enqueue(new Callback<User>() {

            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    model.saveUser(user);
                    view.openEnterprises();
                    LoginHeaders loginHeaders = new LoginHeaders(response.headers().get("uid"), response.headers().get("client"), response.headers().get("access-token"));
                    model.saveLoginHeaders(loginHeaders);
                } else {
                    BufferedReader reader;
                    StringBuilder sb = new StringBuilder();
                    reader = new BufferedReader(new InputStreamReader(response.errorBody().byteStream()));
                    String line;
                    try {
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                        JSONObject jsonObject = new JSONObject(sb.toString());

                        if (jsonObject.has("errors") && !jsonObject.isNull("errors")) {
                            JSONArray errors = jsonObject.getJSONArray("errors");
                            if (errors.length() > 0) {
                                view.setError(errors.get(0).toString());
                            }
                        } else if (jsonObject.has("message")) {
                            view.cleanFieldsErrors();
                            view.showToast(jsonObject.getString("message"));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                view.hideProgressDialog();
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                t.printStackTrace();
                view.hideProgressDialog();
                view.showToast(R.string.errorconect);
            }
        });
    }
}
