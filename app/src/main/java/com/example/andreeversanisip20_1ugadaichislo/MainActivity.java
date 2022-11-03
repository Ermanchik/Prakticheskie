package com.example.andreeversanisip20_1ugadaichislo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText teInput;
    Button bControl;
    int guess;
    boolean gameFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //svyazivaem nashi peremennie
        tvInfo = (TextView)findViewById(R.id.textView3);
        teInput = (EditText)findViewById(R.id.plaintext);
        bControl = (Button)findViewById(R.id.button3);

        guess = (int)(Math.random()*100);
        gameFinish = false;


    }

    public void onClick(View v){

        if (!gameFinish){
            int inp = Integer.parseInt(teInput.getText().toString());
            if (inp > guess)
                tvInfo.setText(getResources().getString(R.string.ahead));
            if (inp < guess)
                tvInfo.setText("nedolyet");
            if (inp == guess)
            {
                tvInfo.setText("v tochku");
                bControl.setText(getResources().getString(R.string.playmore));
                gameFinish = true;
            }
        }
        else
        {
            guess = (int)Math.random()*100;
            bControl.setText("vesti znachenie");
            tvInfo.setText(getResources().getString(R.string.trytoguess));
            gameFinish = false;
        }
    }

}