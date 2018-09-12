package com.vnbamboo.werewolves;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Bấm BACK lần nữa để thoát! ", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        final Context thisContext = this;

        Button btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                EditText edtNumPlayer = (EditText) findViewById(R.id.edtNumPlayer);
                if (Byte.parseByte(edtNumPlayer.getText().toString()) >= 9)
                    startMenuActivity(Byte.parseByte(edtNumPlayer.getText().toString()));
                else {
                    final Toast toast = Toast.makeText(thisContext, "Cần ít nhất 9 người để bắt đầu chơi!", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 750);
                }
            }
        });

    }

    public void startMenuActivity(byte numPlayer){
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("numPlayer", numPlayer);
        this.startActivity(intent);
    }
}
