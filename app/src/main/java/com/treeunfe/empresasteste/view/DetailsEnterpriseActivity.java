package com.treeunfe.empresasteste.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.treeunfe.empresasteste.R;
import com.treeunfe.empresasteste.contract.DetailsEnterpriseContract;
import com.treeunfe.empresasteste.entity.Enterprise;
import com.treeunfe.empresasteste.presenter.DetailsEnterprisePresenter;
import com.treeunfe.empresasteste.util.MConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsEnterpriseActivity extends AppCompatActivity implements DetailsEnterpriseContract.View {

    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.tvDescription)
    TextView tvDescription;
    @BindView(R.id.tvLogo)
    AppCompatTextView tvLogo;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private DetailsEnterpriseContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_enterprise);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new DetailsEnterprisePresenter(this);
        presenter.loadDetails();
    }

    @Override
    public void showEnterprise(Enterprise enterprise) {
        toolbar.setTitle(enterprise.getEnterpriseName());
        showLogo(enterprise);
        tvDescription.setText(enterprise.getDescription());
    }

    private void showLogo(Enterprise enterprise) {
        if (enterprise.getPhoto() != null && !enterprise.getPhoto().isEmpty()) {
            Glide.with(this)
                    .load(MConstants.IMAGES_URL + enterprise.getPhoto())
                    .into(ivLogo);
            showImage(true);
        } else {
            showImage(false);
            tvLogo.setText("E".concat(enterprise.getId().toString()));
        }
    }

    private void showImage(boolean b) {
        ivLogo.setVisibility(b ? View.VISIBLE : View.GONE);
        tvLogo.setVisibility(b ? View.GONE : View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}