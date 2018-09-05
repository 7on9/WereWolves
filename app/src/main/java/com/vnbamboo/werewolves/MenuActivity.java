package com.vnbamboo.werewolves;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    List<Card> cards = new ArrayList<>();
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pick_number);
        getSupportActionBar().hide();

        generateCard();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rclViewItem);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new RecyclerViewAdapter(this, cards ));

        Button btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                cards = RecyclerViewAdapter.cards;
            }
        });
    }
    public void generateCard(){
        String[] PATH_IMG_ROLE = {
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
        String[] FULL_ROLE_NAME = {
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
        for(byte i = 0; i < FULL_ROLE_NAME.length; i++){
            Card temp = new Card(i, FULL_ROLE_NAME[i], PATH_IMG_ROLE[i]);
            cards.add(temp);
        }
    }
}
