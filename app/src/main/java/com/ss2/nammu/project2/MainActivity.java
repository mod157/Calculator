package com.ss2.nammu.project2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_Print;
    Button btn_Number0, btn_Number1,btn_Number2,btn_Number3,btn_Number4,btn_Number5,btn_Number6,btn_Number7,btn_Number8,btn_Number9;
    Button btn_Clear, btn_Print, btn_Point,btn_OneClear;
    Button btn_plus, btn_mina, btn_goap, btn_div;
    Boolean checkNumber = false;
    Object cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){
        tv_Print = (TextView) findViewById(R.id.tv_print);
        btn_OneClear = (Button) findViewById(R.id.btn_onclear);
        btn_Point = (Button) findViewById(R.id.btn_point);
        btn_Print = (Button) findViewById(R.id.btn_print);
        btn_Clear = (Button)findViewById(R.id.btn_clear);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_goap = (Button) findViewById(R.id.btn_goap);
        btn_mina = (Button) findViewById(R.id.btn_mina);
        btn_Number0 = (Button) findViewById(R.id.btn_Number0);
        btn_Number1 = (Button) findViewById(R.id.btn_number1);
        btn_Number2 = (Button) findViewById(R.id.btn_number2);
        btn_Number3 = (Button) findViewById(R.id.btn_number3);
        btn_Number4 = (Button) findViewById(R.id.btn_number4);
        btn_Number5 = (Button) findViewById(R.id.btn_number5);
        btn_Number6 = (Button) findViewById(R.id.btn_number6);
        btn_Number7 = (Button) findViewById(R.id.btn_number7);
        btn_Number8 = (Button) findViewById(R.id.btn_number8);
        btn_Number9 = (Button) findViewById(R.id.btn_number9);
        btn_Print.setOnClickListener(this);
        btn_Clear.setOnClickListener(this);
        btn_Point.setOnClickListener(this);
        btn_OneClear.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_goap.setOnClickListener(this);
        btn_mina.setOnClickListener(this);
        btn_Number0.setOnClickListener(this);
        btn_Number1.setOnClickListener(this);
        btn_Number2.setOnClickListener(this);
        btn_Number3.setOnClickListener(this);
        btn_Number4.setOnClickListener(this);
        btn_Number5.setOnClickListener(this);
        btn_Number6.setOnClickListener(this);
        btn_Number7.setOnClickListener(this);
        btn_Number8.setOnClickListener(this);
        btn_Number9.setOnClickListener(this);
    }
    private boolean checkNumber(int id){
        if(checkNumber)
            return false;

        switch(id) {
            case R.id.btn_Number0:
                tv_Print.append("0");
                break;
            case R.id.btn_number1:
                tv_Print.append("1");
                break;
            case R.id.btn_number2:
                tv_Print.append("2");
                Log.d("Calcu","2");
                break;
            case R.id.btn_number3:
                tv_Print.append("3");
                break;
            case R.id.btn_number4:
                tv_Print.append("4");
                break;
            case R.id.btn_number5:
                tv_Print.append("5");
                break;
            case R.id.btn_number6:
                tv_Print.append("6");
                break;
            case R.id.btn_number7:
                tv_Print.append("7");
                break;
            case R.id.btn_number8:
                tv_Print.append("8");
                break;
            case R.id.btn_number9:
                tv_Print.append("9");
                break;
            default:
                return false;
        }
        return true;
    }
    private void show(){
        String num = tv_Print.getText().toString();
        String[] spl = num.split(" ");
        boolean calcu = false;
        double sum = 0;
        for(int i = 0 ; i<spl.length; i++) {
            switch(spl[i]){
                case "+":
                    if(!calcu) {
                        sum += Double.parseDouble(spl[i - 1]) + Double.parseDouble(spl[i + 1]);
                        calcu = true;
                    } else
                        sum += Double.parseDouble(spl[i+1]);
                    break;
                case "-":
                    if(!calcu) {
                        sum = Double.parseDouble(spl[i-1]) - Double.parseDouble(spl[i+1]);
                        calcu = true;
                    }else
                        sum -= Double.parseDouble(spl[i+1]);
                    break;
                case "*":
                    if(!calcu) {
                        //Log.d("Cal####",""+Integer.parseInt(spl[i-1]) * Integer.parseInt(spl[i+1]) + " : " + (double)(Integer.parseInt(spl[i-1]) * Integer.parseInt(spl[i+1])));
                        sum = Double.parseDouble(spl[i-1]) * Double.parseDouble(spl[i+1]);
                        calcu = true;
                    }else
                        sum *= Double.parseDouble(spl[i+1]);
                    break;
                case "/":
                    if(!calcu) {
                        sum = Double.parseDouble(spl[i-1]) / Double.parseDouble(spl[i+1]);
                        calcu = true;
                    }else
                        sum /= Double.parseDouble(spl[i+1]);

                    break;
            }
        }
        tv_Print.setText(sum+"");
        checkNumber = true;
    }

    @Override
    public void onClick(View view){
        if(checkNumber(view.getId()) == false) {
            switch (view.getId()) {
                case R.id.btn_onclear:
                    String sub = tv_Print.getText().toString();
                    sub = sub.substring(0,sub.length()-1);
                    tv_Print.setText(sub);
                    break;
                case R.id.btn_point:
                    tv_Print.append(".");
                    if(checkNumber)
                        checkNumber = false;
                    break;
                case R.id.btn_plus:
                    tv_Print.append(" + ");
                    if(checkNumber)
                        checkNumber = false;
                    break;
                case R.id.btn_mina:
                    tv_Print.append(" - ");
                    if(checkNumber)
                        checkNumber = false;
                    break;
                case R.id.btn_div:
                    tv_Print.append(" / ");
                    if(checkNumber)
                        checkNumber = false;
                    break;
                case R.id.btn_goap:
                    tv_Print.append(" * ");
                    if(checkNumber)
                        checkNumber = false;
                    break;
                case R.id.btn_clear:
                    tv_Print.setText("");
                    if(checkNumber)
                        checkNumber = false;
                    break;
                case R.id.btn_print:
                    show();
                    break;
            }
        }

    }
}
