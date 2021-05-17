package com.treeunfe.empresasteste.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.treeunfe.empresasteste.R;
import com.treeunfe.empresasteste.entity.Enterprise;
import com.treeunfe.empresasteste.util.MConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EnterpriseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Enterprise> list;
    private List<String> types;
    private Context context;
    private MyListener listener;

    public EnterpriseAdapter(List<Enterprise> list, MyListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_enterprise, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final Enterprise dao = list.get(position);
        final MyViewHolder myHolder = (MyViewHolder) holder;

        myHolder.tvEnterprise.setText(dao.getEnterpriseName());
        myHolder.tvCountry.setText(dao.getCountry());
        if(dao.getEnterpriseType() != null)
            myHolder.tvType.setText(dao.getEnterpriseType().getEnterpriseTypeName());

        setPhoto(dao, myHolder);

        myHolder.cardview.setOnClickListener(view -> listener.onClickItem(dao));

    }

    private void setPhoto(Enterprise dao, MyViewHolder myHolder) {
        if (dao.getPhoto() != null && !dao.getPhoto().isEmpty()) {
            Glide.with(context)
                    .load(MConstants.IMAGES_URL + dao.getPhoto())
                    .into(myHolder.ivEnterprise);
            showImage(myHolder, true);
        } else {
            showImage(myHolder, false);
            myHolder.tvEnterpriseLogo.setText("E".concat(dao.getId().toString()));
        }
    }

    private void showImage(MyViewHolder myHolder, boolean b) {
        myHolder.ivEnterprise.setVisibility(b ? View.VISIBLE : View.GONE);
        myHolder.tvEnterpriseLogo.setVisibility(b ? View.GONE : View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface MyListener {
        void onClickItem(Enterprise enterprise);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cardview)
        CardView cardview;
        @BindView(R.id.ivEnterprise)
        ImageView ivEnterprise;
        @BindView(R.id.tvEnterpriseLogo)
        TextView tvEnterpriseLogo;
        @BindView(R.id.tvEnterprise)
        TextView tvEnterprise;
        @BindView(R.id.tvType)
        TextView tvType;
        @BindView(R.id.tvCountry)
        TextView tvCountry;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
