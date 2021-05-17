package com.treeunfe.empresasteste.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.treeunfe.empresasteste.R;
import com.treeunfe.empresasteste.contract.LoginContract;
import com.treeunfe.empresasteste.presenter.LoginPresenter;
import com.treeunfe.empresasteste.util.MUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.etEmail)
    TextInputEditText etEmail;
    @BindView(R.id.tilEmail)
    TextInputLayout tilEmail;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;
    @BindView(R.id.btLogin)
    Button btLogin;
    @BindView(R.id.tvErrorMessage)
    TextView tvErrorMessage;

    LoginContract.Presenter presenter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        progressDialog = MUtils.getProgressDialog(this);
        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.btLogin)
    void clickLogin() {
        if (MUtils.validarEmail(etEmail.getText().toString()) && etPassword.getText().length() >= 8) {
            cleanFieldsErrors();
            presenter.login();
        } else {
            tvErrorMessage.setError(getString(R.string.invalid_credentials));
            tvErrorMessage.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public String getEmail() {
        return etEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void cleanFieldsErrors() {
        tvErrorMessage.setVisibility(View.GONE);
        tilEmail.setErrorEnabled(false);
        tilPassword.setErrorEnabled(false);
    }

    @Override
    public void setError(String error) {
        tvErrorMessage.setVisibility(View.VISIBLE);
        tvErrorMessage.setText(error);
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void showToast(int message) {
        Toast.makeText(this, getString(message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void openEnterprises() {
        startActivity(new Intent(this, ListEnterprisesActivity.class));
        finish();
    }
}