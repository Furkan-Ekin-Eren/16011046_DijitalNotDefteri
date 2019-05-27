package com.example.mobilproje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class not_show extends AppCompatActivity {
    EditText title,content;
    Button düzenle,pri;
    VeriKaynagi vk = new VeriKaynagi(this) ;
    int id=0;
    int pri_state=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_show);
        title=findViewById(R.id.again_title);
        content=findViewById(R.id.again_content);
        düzenle=findViewById(R.id.button_again);
        pri=findViewById(R.id.button_pri2);
        Intent gel=getIntent();
        Bundle b=gel.getExtras();
        id = b.getInt("id");
        title.setText(b.getString("title"));
        content.setText(b.getString("content"));
        pri_state=b.getInt("pri");
        düzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               hebe();
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
    }

    public void hebe(){
        vk.ac();
        vk.notSil_new(id);
        Intent istek = new Intent(getApplicationContext(),MainActivity.class);
        Date currentTime = Calendar.getInstance().getTime();
        vk.notOlustur(title.getText().toString(),content.getText().toString(),currentTime.toString(),pri_state);
        vk.kapa();
        startActivity(istek);
    }
}
