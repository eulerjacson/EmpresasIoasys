package com.treeunfe.empresasteste.presenter;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.treeunfe.empresasteste.R;
import com.treeunfe.empresasteste.api.SettingsAPI;
import com.treeunfe.empresasteste.contract.ListEnterprisesContract;
import com.treeunfe.empresasteste.entity.Enterprise;
import com.treeunfe.empresasteste.entity.Enterprises;
import com.treeunfe.empresasteste.entity.LoginHeaders;
import com.treeunfe.empresasteste.model.ListEnterprisesModel;
import com.treeunfe.empresasteste.util.MUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListEnterprisesPresenter implements ListEnterprisesContract.Presenter {

    private ListEnterprisesContract.Model model;
    private ListEnterprisesContract.View view;
    private SettingsAPI settingsAPI;

    public ListEnterprisesPresenter(ListEnterprisesContract.View view) {
        this.view = view;
        this.model = new ListEnterprisesModel(MUtils.getMemoryRepository());
        this.settingsAPI = SettingsAPI.getInstance();
    }

    @Override
    public void searchEnterprises(String query) {
        LoginHeaders loginHeaders = model.getLoginHeaders();

        view.showProgress();
        Call<Enterprises> request = settingsAPI.getAPI().getEnterprises(loginHeaders.getAccessToken(), loginHeaders.getUid(), loginHeaders.getClient(), query);
        request.enqueue(new Callback<Enterprises>() {

            @Override
            public void onResponse(@NonNull Call<Enterprises> call, @NonNull Response<Enterprises> response) {
                if (response.isSuccessful()) {
                    Enterprises enterprises = response.body();
                    view.updateRecyclerView(enterprises);
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

                        if (jsonObject.has("data")) {
                            JSONObject error = jsonObject.getJSONObject("data").getJSONObject("error");
                            if (error.has("message")) {
                                view.showToast(error.getString("message"));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                view.hideProgress();
            }

            @Override
            public void onFailure(@NonNull Call<Enterprises> call, @NonNull Throwable t) {
                t.printStackTrace();
                view.showToast(R.string.errorconect);
            }
        });
    }

    @Override
    public void clickItemEnterprise(Enterprise enterprise) {
        model.saveSelectedEnterprise(enterprise);
        view.openDetailsEnterprise();
    }
}
