package com.guerrero.guerrerolabexer2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondActivity extends AppCompatActivity {

    Button btnLoadShared;
    Button btnLoadInternal;
    Button clearrr;
    Button backkk;
    TextView tvdisplay;
    FileInputStream fis;
    BufferedReader br;
    String user, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnLoadShared = (Button) findViewById(R.id.btn_LoadShared);
        btnLoadInternal = (Button) findViewById(R.id.btn_LoadInternal);
        clearrr = (Button) findViewById(R.id.btn_Clear);
        backkk = (Button) findViewById(R.id.btn_Back);
        tvdisplay = (TextView) findViewById(R.id.tv_display);

    }

    public void backkk(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clearrr(View view) {
        tvdisplay.setText("");
    }

    public void loadShared(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());;
        String user = preferences.getString("username","");
        String pwd = preferences.getString("password","");
        tvdisplay.setText("The password of " + user + " is " + pwd);
    }

    public void loadInternal(View view) throws IOException {
        String read = "";
        try{
            fis = openFileInput("output.txt");
            br = new BufferedReader(new InputStreamReader(fis));
            if ((read = br.readLine()) != null)
                user = read;
            if ((read = br.readLine()) != null)
                pwd = read;
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tvdisplay.setText("The password of " + user + " is " + pwd);
    }
}
