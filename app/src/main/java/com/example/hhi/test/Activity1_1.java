package com.example.hhi.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Activity1_1 extends AppCompatActivity {
    TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_1);

        mResult = (TextView)findViewById(R.id.textView2);
        ImageButton btn = (ImageButton)findViewById(R.id.imageButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String Json = "[{\"Voltage\":\"40\", \"Ampere\":\"200\"}," +
                        "{\"Voltage\":\"38\", \"Ampere\":\"220\"}," +
                        "{\"Voltage\":\"37\", \"Ampere\":\"230\"}," +
                        "{\"Voltage\":\"41\", \"Ampere\":\"190\"}]";
                try {
                    String Result = "";
                    JSONArray ja = new JSONArray(Json);

                        JSONObject vi = ja.getJSONObject(0);
                        Result += "전압 : " + vi.getString("Voltage") +"V"+ "\n\n\n"+
                                "전류 : " + vi.getString("Ampere") + "A"+"\n";
                    mResult.setText(Result);
                } catch (JSONException e) {
                    Toast.makeText(v.getContext(), e.getMessage(), 0).show();
                }
            }
        });
    }
}
