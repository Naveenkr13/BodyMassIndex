package com.bmiasn.bmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmi.R;


public class MainActivity extends AppCompatActivity {
//

    RelativeLayout malef;
    RelativeLayout femalef;
ImageView img_male, female_img;
    EditText height_in_ft;

EditText height_in_inch;
EditText weight;
EditText age_e;
Button btn;
TextView result_show;

TextView msg;

    int wt; //for weight
    int ft; //for fit
    int ft_inch; //for inche
    int age; //age
    //...........for select gender if some one not click then not work
String typeuser="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  ................. id find here.............


        //male and female png its relative layout id find here
       malef=(RelativeLayout) findViewById(R.id.male);
      femalef=(RelativeLayout) findViewById(R.id.female);

      //,,,,,,,,,,,,,,,,,,,,,
      img_male=(ImageView)findViewById(R.id.maleimg);
      female_img=(ImageView)findViewById(R.id.femaleimg);
      //,,,,,,,,,,,,
       //height and weight id find
        height_in_ft=(EditText)findViewById(R.id.edit_htf);
        height_in_inch=(EditText)findViewById(R.id.edit_hti);
        weight=(EditText)findViewById(R.id.edit_wt);
        age_e=(EditText)findViewById(R.id.edit_age);
        msg=(TextView)findViewById(R.id.msgshow);
        //,,,,,,,,,,,,,,,,,Button id find,,,,,,,,,,,,
   btn=(Button) findViewById(R.id.btnbmi);

/// ,,,,,,,,,,,,,,,,result textview show,,,,,,,,,,,,,
    result_show=(TextView)findViewById(R.id.result);




//,,,,,,,,,,,,,,,,,,,,male click...........................
        malef.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        malef.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.notfocusedmaleandfemale));
        femalef.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocused));
      typeuser="male";
      Toast.makeText(MainActivity.this, "You choose Male", Toast.LENGTH_SHORT).show();
    }
});

//  ,,,,,,,,....................female click then it happen.................................
        femalef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                femalef.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.notfocusedmaleandfemale));
                malef.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocused));
               typeuser="female";
               Toast.makeText(MainActivity.this, "You Choose Female", Toast.LENGTH_SHORT).show();
            }
        });


///..................Button pe click karne par kya hoga yaha likhe hain...............................

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//......................for select male and female gender.............................
            if(typeuser.equals("0")){
    Toast.makeText(MainActivity.this, "Select Your Gender", Toast.LENGTH_SHORT).show();
              }
            else{
// ye else ke ander hi sara code hai kyunki agar koi gender select karega tab hi processed aage badhe ga warna nahi



                //.............for app not crash even someon not enter somethind..............

                // ............................for age...............................
                if (age_e.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Age", Toast.LENGTH_SHORT).show();

                }else {
                    age=Integer.parseInt(age_e.getText().toString());
                    age_e.setText("");
                }

                //....................for weight if someone enter zero or null then this code for them............
                if (weight.getText().toString().trim().isEmpty()){

                    Toast.makeText(MainActivity.this, "Enter weight", Toast.LENGTH_SHORT).show();
                }else {
                    wt=Integer.parseInt(weight.getText().toString());
                    weight.setText("");
                }
                //..............for height if someone enter nothing or zero then app not crashed...................
                if (height_in_ft.getText().toString().trim().isEmpty()){

                    Toast.makeText(MainActivity.this, "Enter Height in Feet", Toast.LENGTH_SHORT).show();
                }else {
                    ft=Integer.parseInt(height_in_ft.getText().toString());
                     height_in_ft.setText("");
                }

                         //.................for inches...............
                if (height_in_inch.getText().toString().trim().isEmpty()){

                    Toast.makeText(MainActivity.this, "Enter Height in Inches", Toast.LENGTH_SHORT).show();
                }else {
                    ft_inch=Integer.parseInt(height_in_inch.getText().toString());
            height_in_inch.setText("");
                }
//..........................................................................



                //.................formula  please see above code.............

                int totalinch=ft*12+ft_inch;
                double totalcm=totalinch*2.54;
                double totalmeter=totalcm/100;
                double bmi=wt/(totalmeter*totalmeter);
               
                
                
                //...................now its time to display result............................
                if (bmi>25){
                    result_show.setText("Your BMI = "+bmi);
//                    result_show.setBackgroundColor(getResources().getColor(R.color.red));

                    result_show.setTextColor(getResources().getColor(R.color.red));
                    msg.setText(" Overweight See Below chart , Please  do a lot of exercises");
                   msg.setTextColor(getResources().getColor(R.color.red));

                } else if (bmi<18) {
                    result_show.setText("Your BMI ="+bmi);
//                result_show.setBackgroundColor(getResources().getColor(R.color.yellow));
                    result_show.setTextColor(getResources().getColor(R.color.yellow));
                    msg.setText(" You are UnderWeight & Please Follow healthy diet and exercise");
                    msg.setTextColor(getResources().getColor(R.color.yellow));
                }else{
                    result_show.setText("Your BMI ="+bmi);
//                    result_show.setBackgroundColor(getResources().getColor(R.color.green));
                    result_show.setTextColor(getResources().getColor(R.color.green));
                    msg.setText("You are Healthy , Be always fit and healthy");
                    msg.setTextColor(getResources().getColor(R.color.green));

                }
            }
//........................else ka curly braces yaha finish hua hai ok.........................................................

//                //add show when button is clicked
//                if (myinterstitialAd!=null){
//                    myinterstitialAd.show(MainActivity.this);}
//                else{
//                    Log.e("Ad Pending","Ad is Not Ready Yet");
//                }
            }
        });






//        /////////////////// ADMob layae hai yaha
//        //step1
//        MobileAds.initialize(this); //initialise karna jaroori hai eske bina n ho payega
//        //sstep2
//        AdRequest adRequest=new AdRequest.Builder().build(); //adrequest
//
//        //
//        //banner ad ke liye hai
//        adView.loadAd(adRequest);
//
////        //step3
////        //full screen me ad load karwa nahi hai n
//       InterstitialAd.load(this, getString(R.string.inter_ad_unit_id), adRequest, new InterstitialAdLoadCallback() {
////
/////////////////////////////////////////////////
//           @Override
//          public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//            super.onAdLoaded(interstitialAd);
//           myinterstitialAd=interstitialAd;
//        myinterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
//                //
//                   @Override
//                    public void onAdClicked() {
//                       super.onAdClicked();
//                        Log.e("press","ad is loades");
//                    }
////////////////////////add show hua lekin user in dismissed lar diya yani close kar diya hai
////             ///////       //intent ka code ya karna hoga
//                    @Override
//                   public void onAdDismissedFullScreenContent() {
//                       super.onAdDismissedFullScreenContent();
//                    }
//////////////////////ad to load hua par full screen par show nahi hua
//                   @Override
//                   public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
//                       super.onAdFailedToShowFullScreenContent(adError);
//                       myinterstitialAd=null;
//                    }
///////////////////////jab add show jaye to esko null kar denge taki ad dubara load n  ho
//                 @Override
//                    public void onAdImpression() {
//                        super.onAdImpression();
//
//                    }
//////////////////////add load hua hai full screen par ok
//                  @Override
//                    public void onAdShowedFullScreenContent() {                        super.onAdShowedFullScreenContent();
////                       // myinterstitialAd=null;
//                   }
////
//                });
//            }
////
//            @Override
//           public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//              super.onAdFailedToLoad(loadAdError);
//                Log.e("Error",loadAdError.toString());
//           }
//        });
//

//       new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (myinterstitialAd!=null){
//                    myinterstitialAd.show(MainActivity.this);}
//                else{
//                    Log.e("Ad Pending","Ad is Not Ready Yet");}
//            }
//        },5000);
    }
}