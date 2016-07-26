package com.qf.vmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class LeftMenuActivity extends AppCompatActivity {

    private LinearLayout shouye;
    private LinearLayout xilie;
    private LinearLayout muhou;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_menu);
        initView();
    }

    private void initView() {
        muhou = (LinearLayout) findViewById(R.id.muhou_container);
        xilie = (LinearLayout) findViewById(R.id.xilie_container);
        shouye = (LinearLayout) findViewById(R.id.shouye_container);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shouye_container:
                intent = new Intent(LeftMenuActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.xilie_container:
                intent = new Intent(LeftMenuActivity.this, XiLie_Activity.class);
                startActivity(intent);
                break;

            case R.id.muhou_container:
                intent = new Intent(LeftMenuActivity.this, MuHou_Activity.class);
                startActivity(intent);
                break;

            case R.id.floatingButton:
                finish();
        }
    }
}
