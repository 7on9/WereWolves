package com.vnbamboo.werewolves;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        getSupportActionBar().hide();

        final byte cardOrder[] = getIntent().getByteArrayExtra("Order list");
        final TextView txtRoleColumn = (TextView) findViewById(R.id.txtRoleColumnResult);
        final TextView txtNumColumn = (TextView) findViewById(R.id.txtIdColumnResult);

        final Button btnConfirm = (Button) findViewById(R.id.btnConfirmToSeeResult);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {

                //link 2 column

                //convert data to string
                String roleColumn = new String();
                String numColumn = new String();

                for (int id = 0; id < cardOrder.length; id++) {
                    roleColumn += MenuActivity.FULL_ROLE_NAME[cardOrder[id]] + "\n";
                    numColumn +=  "Người chơi " + Integer.toString(id + 1) + "\n";
                }
                //set compoment
                txtNumColumn.setText(numColumn);
                txtRoleColumn.setText(roleColumn);
                btnConfirm.setText("Trở về menu chính!");
                btnConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        finish();
                    }
                });
            }
        });
    }
}
