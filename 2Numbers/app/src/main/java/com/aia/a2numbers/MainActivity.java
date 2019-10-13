package com.aia.a2numbers;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat ;

public class MainActivity extends AppCompatActivity {
    EditText number1 , number2 ;
    TextView result ;
    RadioButton plus , minus , multy , div;
    RadioGroup G ;
    Button calc ;
    MediaPlayer mp;
    double x , y ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.number1);
        number2 =findViewById(R.id.number2);
        result = findViewById(R.id.result);
        plus = findViewById(R.id.plus);
        minus =findViewById(R.id.minus);
        multy =findViewById(R.id.multy);
        div =findViewById(R.id.div);
        G = findViewById(R.id.group);
        mp = MediaPlayer.create(this,R.raw.button);
        calc = findViewById(R.id.calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number1.getText().toString().isEmpty()==false && number2.getText().toString().isEmpty()==false && G.isEnabled()==true  )
                {
                    x = Double.parseDouble(number1.getText().toString());
                    y = Double.parseDouble(number2.getText().toString());

                    DecimalFormat df = new DecimalFormat("####.####");
                    df.setRoundingMode(RoundingMode.DOWN);


                    if(plus.isChecked()){result.setText(String.valueOf(x+y));}
                    else if(minus.isChecked()){result.setText(String.valueOf(x-y));}
                    else if(multy.isChecked()){result.setText(String.valueOf(x*y));}
                    else {result.setText(String.valueOf(df.format(x/y)));}
                    mp.start();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_LONG).show();
                }
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1.setText(result.getText());
                number2.setText("");
                mp.start();
            }
        });
    }
}
