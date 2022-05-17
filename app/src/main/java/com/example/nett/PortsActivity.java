package com.example.nett;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import IPScanner.LocalPortScanner;

public class PortsActivity extends Activity {
    EditText portStartBox;
    EditText portEndBox;
    TextView resultBox;
    Button scanButton;
    Button clearButton;
    LocalPortScanner localPortScanner;
    Map<String, List<Integer>> result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ports_layout);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        portStartBox = findViewById(R.id.portlabel1);
        portEndBox = findViewById(R.id.portlabel2);
        resultBox = findViewById(R.id.textview1);
        scanButton = findViewById(R.id.start);
        clearButton = findViewById(R.id.wyczysc1);

        scanButton.setOnClickListener(view -> {
            StringBuilder sb = null;
            Integer startPort = Integer.valueOf(portStartBox.getText().toString());
            Integer endPort = Integer.valueOf(portEndBox.getText().toString());
            try {
                localPortScanner = new LocalPortScanner(startPort, endPort);
                result = new HashMap<>(localPortScanner.getInetSocketAddresses());
                sb = new StringBuilder();

                for (String s : result.keySet()){
                    sb.append(s)
                            .append(": ")
                            .append(result.get(s))
                            .append("\n");
                }

            } catch (UnknownHostException e) {
                resultBox.setText(new StringBuilder().append("Nieznany błąd\n").append(e.getCause()).toString());
            } catch (IOException e) {
                resultBox.setText(new StringBuilder().append("Błąd we / wy\n").append((CharSequence) e.getCause()).toString());
            } catch (InterruptedException e) {
                resultBox.setText(new StringBuilder().append("Błąd przerwania\n").append(e.getCause()).toString());
            }
            resultBox.setText(Objects.requireNonNull(sb).toString());
        });

        clearButton.setOnClickListener(view -> {
            portStartBox.setText("");
            portEndBox.setText("");
            resultBox.setText("");
        });
    }
}
