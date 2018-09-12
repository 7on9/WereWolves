package com.vnbamboo.werewolves;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NextPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_player);
//        getSupportActionBar().hide();

        final byte cardOrder[] = getIntent().getByteArrayExtra("Order list");
        final byte roleOfThisPlayer = getIntent().getByteExtra("Position", (byte) 0);

        Button btnToShowCard = (Button) findViewById(R.id.btnToShowCard);
        btnToShowCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                showRole(cardOrder, roleOfThisPlayer);
            }
        });
    }
    public void showRole(byte[] cardOrder, byte roleOfThisPlayer){
        Intent intent = new Intent(this, ShowRoleActivity.class);
        intent.putExtra("Position", roleOfThisPlayer);
        intent.putExtra("Order list", cardOrder);
        super.startActivity(intent);
    }
}
