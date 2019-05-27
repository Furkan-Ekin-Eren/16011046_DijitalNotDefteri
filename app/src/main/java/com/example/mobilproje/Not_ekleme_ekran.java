package com.example.mobilproje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Not_ekleme_ekran extends AppCompatActivity {
    EditText title,content;
    Button attachment,save,noti,pri;
    int pri_state=0;

    VeriKaynagi vk = new VeriKaynagi(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_ekleme_ekran);
        title = findViewById(R.id.editT_title);
        content = findViewById(R.id.editT_content);
        attachment = findViewById(R.id.button_attachment);
        save = findViewById(R.id.button_kaydet);
        noti = findViewById(R.id.button_noti);
        pri=findViewById(R.id.button_pri);
        vk.ac();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent istek = new Intent(getApplicationContext(),MainActivity.class);
                Date currentTime = Calendar.getInstance().getTime();
                vk.notOlustur(title.getText().toString(),content.getText().toString(),currentTime.toString(),pri_state);
                vk.kapa();
                startActivity(istek);

            }
        });

        pri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pri_state==0){
                    pri_state=1;
                    Toast.makeText(getApplicationContext(),"Priority Eklendi",Toast.LENGTH_SHORT).show();
                }else{
                    pri_state=0;
                    Toast.makeText(getApplicationContext(),"Priority Çıkarıldı",Toast.LENGTH_SHORT).show();
                }

            }
        });

        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
