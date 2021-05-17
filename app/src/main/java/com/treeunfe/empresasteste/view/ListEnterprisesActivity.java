package com.treeunfe.empresasteste.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.treeunfe.empresasteste.R;
import com.treeunfe.empresasteste.contract.ListEnterprisesContract;
import com.treeunfe.empresasteste.entity.Enterprise;
import com.treeunfe.empresasteste.entity.Enterprises;
import com.treeunfe.empresasteste.presenter.ListEnterprisesPresenter;
import com.treeunfe.empresasteste.view.adapter.EnterpriseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListEnterprisesActivity extends AppCompatActivity implements ListEnterprisesContract.View, EnterpriseAdapter.MyListener {

    @BindView(R.id.tvClickSearch)
    AppCompatTextView tvClickSearch;
    @BindView(R.id.rvEnterprises)
    RecyclerView rvEnterprises;
    @BindView(R.id.tvEmptySearch)
    AppCompatTextView tvEmptySearch;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private ListEnterprisesContract.Presenter presenter;
    private EnterpriseAdapter enterpriseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_enterprises);
        ButterKnife.bind(this);

        presenter = new ListEnterprisesPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                presenter.searchEnterprises(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (tvClickSearch.getVisibility() != View.GONE)
                    tvClickSearch.setVisibility(View.GONE);
                return false;
            }
        });

        return true;
    }

    @Override
    public void showToast(int message) {
        Toast.makeText(this, getString(message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateRecyclerView(Enterprises enterprises) {
        tvEmptySearch.setVisibility(enterprises.getEnterprises().isEmpty() ? View.VISIBLE : View.GONE);
        enterpriseAdapter = new EnterpriseAdapter(enterprises.getEnterprises(), this);
        rvEnterprises.setLayoutManager(new LinearLayoutManager(this));
        rvEnterprises.setAdapter(enterpriseAdapter);
    }

    @Override
    public void openDetailsEnterprise() {
        startActivity(new Intent(this, DetailsEnterpriseActivity.class));
    }

    @Override
    public void onClickItem(Enterprise enterprise) {
        presenter.clickItemEnterprise(enterprise);
    }
}