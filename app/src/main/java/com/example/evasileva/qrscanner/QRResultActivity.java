package com.example.evasileva.qrscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QRResultActivity extends AppCompatActivity {

    TextView name, phone, comment, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrresult);

        name = (TextView)findViewById(R.id.name);
        phone = (TextView)findViewById(R.id.phone);
        comment = (TextView)findViewById(R.id.comment);
        sum = (TextView)findViewById(R.id.sum);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        String getName = (String)bd.get("code");

        //barcode to HashMap
        getName = getName.substring(1, getName.length()-1);
        String[] keyValuePairs = getName.split(",");
        Map<String,String> map = new LinkedHashMap<>();

        for (String pair: keyValuePairs){
            String[] entry = pair.split("=");
            map.put(entry[0].trim(), entry[1].trim());
        }

        name.setText(map.get("name"));
        phone.setText(map.get("phone"));
        comment.setText(map.get("comment"));
        sum.setText(map.get("sum"));



    }


}
