package com.vnbamboo.werewolves;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    public static final String[] PATH_IMG_ROLE = {
            "badong",
            "baove",
            "conlai",
            "cupid",
            "danlang",
            "gau",
            "gialang",
            "kisi",
            "nguyetnu",
            "phuthuy",
            "phuthuycam",
            "soibang",
            "soiden",
            "soitrang",
            "thosan",
            "tientri",
            "tihi"};
    public static final String[] FULL_ROLE_NAME = {
            "Bà đồng",
            "Bảo vệ",
            "Con lai",
            "Cupid",
            "Dân làng",
            "Thần gấu",
            "Già làng",
            "Kị sĩ",
            "Nguyệt nữ",
            "Phù thủy",
            "Phù thủy câm",
            "Sói băng",
            "Sói đen",
            "Sói trắng",
            "Thợ săn",
            "Tiên tri",
            "Ti hí"};
    private Context context;
    private int totalItem;
    public RecyclerViewAdapter( RecyclerView recyclerView, Context context){
        this.context = context;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder( @NonNull RecyclerView.ViewHolder holder, int position ) {

    }
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        EditText editTxtNum;
        TableLayout line;
        ImageView imgRole;
        TextView txtRole;

        public ItemViewHolder( View itemView ) {
            super(itemView);
            editTxtNum = (EditText) itemView.findViewById(R.id.editTxtNum);
            line = itemView.findViewById(R.id.line);
            txtRole = (TextView) itemView.findViewById(R.id.txtRole);
            imgRole = (ImageView) itemView.findViewById(R.id.imgRole);
        }
        void bindData(int post){
            this.txtRole.setText(FULL_ROLE_NAME[post]);
            int id = context.getResources().getIdentifier("werewolves:drawable" + PATH_IMG_ROLE[post], null, null);
            this.imgRole.setImageResource(id);

        }

    }

    @Override
    public int getItemCount() {
        return FULL_ROLE_NAME.length;
    }
}
