package com.example.nett;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageButton im_ip = (ImageButton)findViewById(R.id.ip);
        ImageButton im_ports = (ImageButton)findViewById(R.id.ports);
        ImageButton im_hosts = (ImageButton)findViewById(R.id.hosts);

        final Context context = this;
        im_ip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Adresacja IP", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), IpActivity.class);
                startActivity(intent);
            }
        });

        im_ports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Skaner portów", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), PortsActivity.class);
                startActivity(intent);
            }
        });

        im_hosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Skanowanie zdalnego hosta", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), HostsActivity.class);
                startActivity(intent);
            }
        });
    }
}