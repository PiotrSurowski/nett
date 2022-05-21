package com.example.nett;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton im_ip = findViewById(R.id.ip);
        ImageButton im_ports = findViewById(R.id.ports);
        ImageButton im_hosts = findViewById(R.id.hosts);

        final Context context = this;

        im_ip.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Adresacja IP", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), IpActivity.class);
            startActivity(intent);
        });

        im_ports.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Skaner portów", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), PortsActivity.class);
            startActivity(intent);
        });

        im_hosts.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Skanowanie zdalnego hosta", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), HostsActivity.class);
            startActivity(intent);
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        startMainActivity();
                        break;
                    case R.id.menuAuthors:
                        Toast.makeText(MainActivity.this, "Autorzy", Toast.LENGTH_SHORT).show();
                        startNewActivity();
                        break;
                    case R.id.exit:
                        Toast.makeText(MainActivity.this, "Wyjście", Toast.LENGTH_SHORT).show();
                        finishActivity();
                        break;
                }
                return true;
            }
        });
    }

    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void startNewActivity(){
        Intent intent = new Intent(this, AuthorsActivity.class);
        startActivity(intent);
        finish();
    }

    private void finishActivity(){
        this.finishActivity();
    }

}