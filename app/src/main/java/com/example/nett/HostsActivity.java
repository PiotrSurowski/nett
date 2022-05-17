package com.example.nett;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import IPScanner.PortScanner;
import IPScanner.RemotePortScanner;

public class HostsActivity extends Activity {

    EditText inputAddress;
    EditText portStartBox;
    EditText portEndBox;
    public TextView resultBox;
    Button scanButton;
    Button clearButton;
    RemotePortScanner portScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hosts_layout);

        inputAddress = (EditText) findViewById(R.id.hostlabel3);
        portStartBox = (EditText) findViewById(R.id.hostlabel1);
        portEndBox = (EditText) findViewById(R.id.hostlabel2);
        resultBox = (TextView) findViewById(R.id.textview2);
        scanButton = (Button) findViewById(R.id.start2);
        clearButton = (Button) findViewById(R.id.wyczysc2);

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = inputAddress.getText().toString();
                Integer portStart = Integer.valueOf(portStartBox.getText().toString());
                Integer portEnd = Integer.valueOf(portEndBox.getText().toString());
                portScanner = new RemotePortScanner(address, portStart,portEnd);
                List<Integer> result = new ArrayList<>(portScanner.getOpenPorts());
                StringBuilder sb = new StringBuilder();

                for (Integer i : result){
                    sb.append(String.valueOf(i))
                            .append("\n");
                }

                resultBox.setText(String.valueOf(sb.toString()));

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputAddress.setText("");
                portStartBox.setText("");
                portEndBox.setText("");
                resultBox.setText("");
            }
        });
    }
}
