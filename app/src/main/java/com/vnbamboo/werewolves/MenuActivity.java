package com.vnbamboo.werewolves;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    List<Card> cards = new ArrayList<>();
    byte numPlayer;
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

        Intent intent = getIntent();
        numPlayer = intent.getByteExtra("numPlayer", (byte) 0);

        recyclerView.setAdapter(new RecyclerViewAdapter(this, cards, numPlayer ));

        final Context thisContext = this;
        Button btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {

                cards = RecyclerViewAdapter.cards;

                View confirmDialog = getLayoutInflater().inflate(R.layout.confirm_dialog, null);

                TextView txtRoleColumn = confirmDialog.findViewById(R.id.txtRoleColumn);
                TextView txtNumColumn = confirmDialog.findViewById(R.id.txtNumColumn);

                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(thisContext);
                alertDialog.setTitle("Xác nhận các vai trò đã chọn");


                String roleColumn = new String();
                String numColumn = new String();
                for (int id = 0; id < cards.size(); id++){
                    roleColumn +=  cards.get(id).getName() + "\n";
                    numColumn += Integer.toString(cards.get(id).getNumOrder()) + "\n";
                }

                txtNumColumn.setText(numColumn);
                txtRoleColumn.setText(roleColumn);
                alertDialog.setView(confirmDialog);

                alertDialog.setPositiveButton("Tiếp tục", new DialogInterface. OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //start new activity
                        finish();
                    }});
                alertDialog.setNegativeButton("Chọn lại", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which){
                        dialog.cancel();
                    }

                });
                alertDialog.create().show();
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
