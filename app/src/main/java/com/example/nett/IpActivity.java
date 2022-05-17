package com.example.nett;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Addressation.IPAddressation;
import Addressation.IPAddressationService;

public class IpActivity extends Activity {

    EditText firstOct;
    EditText secondOct;
    EditText thirdOct;
    EditText fourthOct;
    EditText fifthOct;
    EditText sixthOct;
    EditText seventhOct;
    EditText eightOct;
    TextView viewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ip_layout);

        Button buttonCalculate = (Button) findViewById(R.id.oblicz);
        Button buttonClear = (Button) findViewById(R.id.wyczysc);
        firstOct = (EditText) findViewById(R.id.first);
        secondOct = (EditText) findViewById(R.id.second);
        thirdOct = (EditText) findViewById(R.id.third);
        fourthOct = (EditText) findViewById(R.id.fourth);
        fifthOct = (EditText) findViewById(R.id.fifth);
        sixthOct = (EditText) findViewById(R.id.six);
        seventhOct = (EditText) findViewById(R.id.seven);
        eightOct = (EditText) findViewById(R.id.eight);
        viewResult = (TextView) findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }

    private void calculate(){
        String address = null;
        Integer i1 = Integer.valueOf(firstOct.getText().toString());
        Integer i2 = Integer.valueOf(secondOct.getText().toString());
        Integer i3 = Integer.valueOf(thirdOct.getText().toString());
        Integer i4 = Integer.valueOf(fourthOct.getText().toString());
        Integer m1 = Integer.valueOf(fifthOct.getText().toString());
        Integer m2 = Integer.valueOf(sixthOct.getText().toString());
        Integer m3 = Integer.valueOf(seventhOct.getText().toString());
        Integer m4 = Integer.valueOf(eightOct.getText().toString());
        StringBuilder sb = new StringBuilder();

        IPAddressationService service = new IPAddressationService(
                i1
                , i2
                , i3
                , i4
                , m1
                , m2
                , m3
                , m4);

        sb.append("Adres: ")
                .append(String.valueOf(service.getAddress()))
                .append("\nMaska :")
                .append(String.valueOf(service.getMask()))
                .append("\nAdres sieci: ")
                .append(String.valueOf(service.getNetworkAddress()))
                .append("\nAdres rozgłoszeniowy: ")
                .append(String.valueOf(service.getBroadcastAddress()))
                .append("\n Maksymalna liczba hostów: ")
                .append(String.valueOf(service.getHostMax()));

        viewResult.setText(sb.toString());

    }

    private void clear(){
        firstOct.setText("");
        secondOct.setText("");
        thirdOct.setText("");
        fourthOct.setText("");
        fifthOct.setText("");
        sixthOct.setText("");
        seventhOct.setText("");
        eightOct.setText("");
        viewResult.setText("");
    }
}
