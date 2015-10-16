
package org.nsu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    int SUM_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText number1EditText = (EditText)findViewById(R.id.number1);
        final EditText number2EditText = (EditText)findViewById(R.id.number2);
        result = (TextView)findViewById(R.id.result);
        Button button = (Button) findViewById(R.id.calculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = number1EditText.getText().toString();
                int number1Val = Integer.parseInt(number1);
                String number2 = number2EditText.getText().toString();
                int number2Val = Integer.parseInt(number2);

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("number1key",number1Val);
                intent.putExtra("number2key",number2Val);
                startActivityForResult(intent, SUM_REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SUM_REQUEST_CODE){
            if(resultCode==RESULT_OK){
                int resultVal = data.getIntExtra("resultkey",0);
                result.setText("Result is "+resultVal);
            }
        }
    }
}
