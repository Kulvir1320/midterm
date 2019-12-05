package com.example.a764928_kulvir_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView DialyRent;
    SeekBar seekBar;
    TextView days;
    RadioGroup radioGroup;
    EditText amount;
    EditText totalAmount;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
     double carsRent = 0;
     double numbOfDays = 1;
     double PriceAmount = 0;
     double total = 0;
     Button btn;
    ArrayList<String> details;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] carRent = getResources().getStringArray(R.array.carRents);
        spinner = findViewById(R.id.spinner);
       DialyRent = findViewById(R.id.dialyRent);
       seekBar = findViewById(R.id.seekbar);
        days = findViewById(R.id.days);
        radioGroup = findViewById(R.id.radioGroup);
        amount = findViewById(R.id.amount);
        totalAmount = findViewById(R.id.totalAmount);
        checkBox1 = findViewById(R.id.Check1);
        checkBox2 = findViewById(R.id.check2);
        checkBox3 = findViewById(R.id.check3);
        btn = findViewById(R.id.btn3);
        details = new ArrayList<>();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                days.setText(String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

   spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
       @Override
       public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
           DialyRent.setText(carRent[i]);
           details.add(spinner.getSelectedItem().toString());
       }

       @Override
       public void onNothingSelected(AdapterView<?> adapterView) {

       }
   });
   checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


               carsRent += 5;
               rent();
               amount.setText(String.valueOf(PriceAmount));
               totalAmount.setText(String.valueOf(total));
                details.add("gps");

       }
   });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                carsRent += 7;
                rent();
                amount.setText(String.valueOf(PriceAmount));
                totalAmount.setText(String.valueOf(total));
                details.add("child seat");

            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                carsRent += 10;
                rent();
                amount.setText(String.valueOf(PriceAmount));
                totalAmount.setText(String.valueOf(total));
                details.add("unlimted milage");

            }
        });

   radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(RadioGroup radioGroup, int i) {



        switch(i){
            case R.id.rb1:
                carsRent +=5;
                rent();
              amount.setText(String.valueOf(PriceAmount));
                totalAmount.setText(String.valueOf(total));
                details.add("less than 20");
                break;
            case R.id.rb2:
                carsRent += 0;
                rent();
              amount.setText(String.valueOf(PriceAmount));
              totalAmount.setText(String.valueOf(total));
                details.add("between 20 and 60");
                break;
            case R.id.rb3:
                carsRent -= 10;
                rent();
                amount.setText(String.valueOf(PriceAmount));
                totalAmount.setText(String.valueOf(total));
                details.add("more than 60");

                 break;
        }

       }
   });
   btn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           Intent intent = new Intent(MainActivity.this,Main2Activity.class);
           intent.putStringArrayListExtra("detail", details);
           startActivity(intent);



       }
   });

    }

//  public void calculatePrice(View v){
//        int id = radioGroup.getCheckedRadioButtonId();
//        double total = 0.0;
//        int carRent = Integer.parseInt(DialyRent.getText().toString());
//        switch(id){
//            case R.id.rb1:
//              total = carRent + 5.0;
////              amount.setText(String.valueOf(total));
//                break;
//            case R.id.rb2:
//              total = carRent;
////              amount.setText(String.valueOf(total));
//                break;
//            case R.id.rb3:
//    total = carRent - 10.0;
//
//                 break;
//        }
//       amount.setText(String.valueOf(total));
//  }



public void rent(){
        PriceAmount = carsRent * numbOfDays;
        total = PriceAmount *0.13;
}
    }
