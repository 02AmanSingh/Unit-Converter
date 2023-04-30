package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.txtnumber);
        sp1=findViewById(R.id.spfrom);
        sp2=findViewById(R.id.spto);
        b1=findViewById(R.id.convert);


        String[] from={"Meters","Grams","CentiMeters","KiloGrams"};
        ArrayAdapter ad=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String[] to={"Meters","Grams","CentiMeters","KiloGrams"};
        ArrayAdapter ad1=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double tot;
                Double num=Double.parseDouble(ed1.getText().toString());

                if(sp1.getSelectedItem().toString()=="Meters" && sp2.getSelectedItem().toString()=="CentiMeters"){
                    tot=num*100;
                    Toast.makeText(getApplicationContext(),tot.toString() , Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="Grams" && sp2.getSelectedItem().toString()=="KiloGrams"){
                    tot=num/1000;
                    Toast.makeText(getApplicationContext(),tot.toString() , Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="CentiMeters" && sp2.getSelectedItem().toString()=="Meters"){
                    tot=num/100;
                    Toast.makeText(getApplicationContext(),tot.toString() , Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="KiloGrams" && sp2.getSelectedItem().toString()=="Grams"){
                    tot=num*1000;
                    Toast.makeText(getApplicationContext(),tot.toString() , Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}