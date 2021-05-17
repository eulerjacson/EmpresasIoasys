package com.treeunfe.empresasteste.api;

import com.treeunfe.empresasteste.util.MConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SettingsAPI {
    private static SettingsAPI sInstance;
    private ISettingsAPI iSettingsAPI;
    private Retrofit retrofit;

    private SettingsAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient().build())
                .build();

        this.iSettingsAPI = retrofit.create(ISettingsAPI.class);

    }

    public static SettingsAPI getInstance() {
        if (sInstance == null) {
            synchronized (SettingsAPI.class) {
                if (sInstance == null) sInstance = new SettingsAPI();
            }
        }
        return sInstance;
    }

    public ISettingsAPI getAPI() {
        return iSettingsAPI;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private OkHttpClient.Builder getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);
        return httpClient;
    }
}
