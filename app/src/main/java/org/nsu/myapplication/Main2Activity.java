package org.nsu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    int number3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int number1 = getIntent().getIntExtra("number1key",0);
        int number2 = getIntent().getIntExtra("number2key",0);
        number3 = number1+number2;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("resultkey",number3);
        setResult(RESULT_OK, intent);
        finish();
    }
}
