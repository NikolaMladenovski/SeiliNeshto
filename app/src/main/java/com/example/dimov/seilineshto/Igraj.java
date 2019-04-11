package com.example.dimov.seilineshto;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.Calendar;

import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_DATE;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_NAME;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_ID;
import static com.example.dimov.seilineshto.Contract.TodoList.COLUMN_SCORE;
import static com.example.dimov.seilineshto.Contract.TodoList.SCORE_TABLE;

public class Igraj extends AppCompatActivity {

    public int niza[] = {1,5,10,20,30,40,50,100,250,500,750,1000,2000,3000,4000,5000,10000,20000,35000,100000,250000,1000000};
    int pomosna[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public int prva = 0;
    public int ponuda1 = 0;
    public int ponuda2 = 0;
    double presmetajSuma=0;
    int runda  = 0;
    int flag = 0;
    EditText zacuvajEdit;
    Button zacuvaj;

    //za settings
    SharedPreferences sharedPref;
    Boolean save;

    private AdView mAdView;


    private String queryUri = Contract.CONTENT_URI.toString();
    private static final String[] projection = new String[]{Contract.CONTENT_PATH};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igraj);

        zacuvaj = findViewById(R.id.buttonZacuvaj);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(dm.widthPixels/dm.xdpi,2);
        double y = Math.pow(dm.heightPixels/dm.ydpi,2);
        double screenInches = Math.sqrt(x+y);

        srediGolemini(x, y, screenInches);


        //settings
        sharedPref =PreferenceManager.getDefaultSharedPreferences(this);
        save = sharedPref.getBoolean
                ("switch_preference_2", false);

    }

    public void srediGolemini(double w, double h,double inch){

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
        Button button13 = findViewById(R.id.button13);
        Button button14 = findViewById(R.id.button14);
        Button button15 = findViewById(R.id.button15);
        Button button16 = findViewById(R.id.button16);
        Button button17 = findViewById(R.id.button17);
        Button button18 = findViewById(R.id.button18);
        Button button19 = findViewById(R.id.button19);
        Button button20 = findViewById(R.id.button20);
        Button button21 = findViewById(R.id.button21);
        Button button22 = findViewById(R.id.button22);


         if(inch > 5.5){
            //prva
            RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) button1.getLayoutParams();
            params1.width = 250;
            button1.setLayoutParams(params1);

            RelativeLayout.LayoutParams params6 = (RelativeLayout.LayoutParams) button6.getLayoutParams();
            params6.width = 250;
            button6.setLayoutParams(params6);

            RelativeLayout.LayoutParams params11 = (RelativeLayout.LayoutParams) button11.getLayoutParams();
            params11.width = 250;
            button11.setLayoutParams(params11);

            RelativeLayout.LayoutParams params16 = (RelativeLayout.LayoutParams) button16.getLayoutParams();
            params16.width = 250;
            button16.setLayoutParams(params16);

            RelativeLayout.LayoutParams params21 = (RelativeLayout.LayoutParams) button21.getLayoutParams();
            params21.width = 250;
            button21.setLayoutParams(params21);

            //vtora

            int sizeInDP = 5;
            int leftM = 230;
            int pedeset = 50;
            int devedeset = 95;
            int stocet = 140;

            int marginInDp = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, sizeInDP, getResources()
                            .getDisplayMetrics());

            int marginLeft = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, leftM, getResources()
                            .getDisplayMetrics());

            int marginPedeset = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, pedeset, getResources()
                            .getDisplayMetrics());

            int marginDevedeset = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, devedeset, getResources()
                            .getDisplayMetrics());

            int marginStocet = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, stocet, getResources()
                            .getDisplayMetrics());



            RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) button2.getLayoutParams();
            params2.width = 250;
            params2.setMargins(marginLeft,marginInDp,0,0);
            button2.setLayoutParams(params2);

            RelativeLayout.LayoutParams params7 = (RelativeLayout.LayoutParams) button7.getLayoutParams();
            params7.width = 250;
            params7.setMargins(marginLeft,marginPedeset,0,0);
            button7.setLayoutParams(params7);

            RelativeLayout.LayoutParams params12 = (RelativeLayout.LayoutParams) button12.getLayoutParams();
            params12.width = 250;
            params12.setMargins(marginLeft,marginDevedeset,0,0);
            button12.setLayoutParams(params12);

            RelativeLayout.LayoutParams params17 = (RelativeLayout.LayoutParams) button17.getLayoutParams();
            params17.width = 250;
            params17.setMargins(marginLeft,marginStocet,0,0);
            button17.setLayoutParams(params17);

            //treta

            int leftM2 = 320;
            int marginLeft2 = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, leftM2, getResources()
                            .getDisplayMetrics());

            RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) button3.getLayoutParams();
            params3.width = 250;
            params3.setMargins(marginLeft2,marginInDp,0,0);
            button3.setLayoutParams(params3);

            RelativeLayout.LayoutParams params8 = (RelativeLayout.LayoutParams) button8.getLayoutParams();
            params8.width = 250;
            params8.setMargins(marginLeft2,marginPedeset,0,0);
            button8.setLayoutParams(params8);

            RelativeLayout.LayoutParams params13 = (RelativeLayout.LayoutParams) button13.getLayoutParams();
            params13.width = 250;
            params13.setMargins(marginLeft2,marginDevedeset,0,0);
            button13.setLayoutParams(params13);

            RelativeLayout.LayoutParams params18 = (RelativeLayout.LayoutParams) button18.getLayoutParams();
            params18.width = 250;
            params18.setMargins(marginLeft2,marginStocet,0,0);
            button18.setLayoutParams(params18);

            //cetvrta
            int leftM3 = 415;
            int marginLeft3 = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, leftM3, getResources()
                            .getDisplayMetrics());

            RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) button4.getLayoutParams();
            params4.width = 250;
            params4.setMargins(marginLeft3,marginInDp,0,0);
            button4.setLayoutParams(params4);

            RelativeLayout.LayoutParams params9 = (RelativeLayout.LayoutParams) button9.getLayoutParams();
            params9.width = 250;
            params9.setMargins(marginLeft3,marginPedeset,0,0);
            button9.setLayoutParams(params9);

            RelativeLayout.LayoutParams params14 = (RelativeLayout.LayoutParams) button14.getLayoutParams();
            params14.width = 250;
            params14.setMargins(marginLeft3,marginDevedeset,0,0);
            button14.setLayoutParams(params14);

            RelativeLayout.LayoutParams params19 = (RelativeLayout.LayoutParams) button19.getLayoutParams();
            params19.width = 250;
            params19.setMargins(marginLeft3,marginStocet,0,0);
            button19.setLayoutParams(params19);

            //petta

            int dole = 260;
            int marginDole = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, dole, getResources()
                            .getDisplayMetrics());

            int leftM4 = 510;
            int marginLeft4 = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, leftM4, getResources()
                            .getDisplayMetrics());

            int leftM5 = 450;
            int marginLeft5 = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, leftM5, getResources()
                            .getDisplayMetrics());

            int leftM6 = 190;
            int marginLeft6 = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, leftM6, getResources()
                            .getDisplayMetrics());

            int stose = 185;
            int stosee = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, stose, getResources()
                            .getDisplayMetrics());

            RelativeLayout.LayoutParams params5 = (RelativeLayout.LayoutParams) button5.getLayoutParams();
            params5.width = 250;
            params5.setMargins(marginLeft4,marginInDp,0,0);
            button5.setLayoutParams(params5);

            RelativeLayout.LayoutParams params10 = (RelativeLayout.LayoutParams) button10.getLayoutParams();
            params10.width = 250;
            params10.setMargins(marginLeft4,marginPedeset,0,0);
            button10.setLayoutParams(params10);

            RelativeLayout.LayoutParams params15 = (RelativeLayout.LayoutParams) button15.getLayoutParams();
            params15.width = 250;
            params15.setMargins(marginLeft4,marginDevedeset,0,0);
            button15.setLayoutParams(params15);

            RelativeLayout.LayoutParams params20 = (RelativeLayout.LayoutParams) button20.getLayoutParams();
            params20.width = 250;
            params20.setMargins(marginLeft4,marginStocet,0,0);
            button20.setLayoutParams(params20);

            RelativeLayout.LayoutParams params22 = (RelativeLayout.LayoutParams) button22.getLayoutParams();
            params22.width = 250;
            params22.setMargins(marginLeft4,stosee,0,0);
            button22.setLayoutParams(params22);


            TextView prikazi = findViewById(R.id.prikazi);
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) prikazi.getLayoutParams();
            lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
            prikazi.setLayoutParams(lp);

            TextView ponuda = findViewById(R.id.ponuda);
            RelativeLayout.LayoutParams lp3 = (RelativeLayout.LayoutParams) ponuda.getLayoutParams();
            lp3.addRule(RelativeLayout.CENTER_HORIZONTAL);
            ponuda.setLayoutParams(lp3);

            Button mojaKutija = findViewById(R.id.mojaKutija);
            RelativeLayout.LayoutParams lp2 = (RelativeLayout.LayoutParams) mojaKutija.getLayoutParams();
            lp2.addRule(RelativeLayout.CENTER_HORIZONTAL);
            mojaKutija.setLayoutParams(lp2);

            Button prifati = findViewById(R.id.prifati);
            RelativeLayout.LayoutParams lp7 = (RelativeLayout.LayoutParams) prifati.getLayoutParams();
            lp7.setMargins(marginLeft6,marginDole,0,0);
            prifati.setLayoutParams(lp7);

            Button odbij = findViewById(R.id.odbij);
            RelativeLayout.LayoutParams lp4 = (RelativeLayout.LayoutParams) odbij.getLayoutParams();
            lp4.setMargins(marginLeft5,marginDole,0,0);
            odbij.setLayoutParams(lp4);


        }





    }

    public void otvoriKutija(Button zatvori, int brojKutija){
        Button mojaKutija = findViewById(R.id.mojaKutija);
        TextView prikazi = findViewById(R.id.prikazi);

        if(prva == 0){
            mojaKutija.setVisibility(View.VISIBLE);
            zatvori.setVisibility(View.GONE);
            mojaKutija.setText(String.valueOf(brojKutija));
            prva++;
            prikazi.setText("Отварате уште 5 кутии оваа рунда");
        }
        else {

            int index = (int)((Math.random()*niza.length));
            int suma = niza[index];
            TextView sumaZatvori = findViewById(R.id.textView1);
            switch (suma) {
                case 1:sumaZatvori = findViewById(R.id.textView1); break;
                case 5:sumaZatvori = findViewById(R.id.textView2); break;
                case 10:sumaZatvori = findViewById(R.id.textView3); break;
                case 20:sumaZatvori = findViewById(R.id.textView4); break;
                case 30:sumaZatvori = findViewById(R.id.textView5); break;
                case 40:sumaZatvori = findViewById(R.id.textView6); break;
                case 50:sumaZatvori = findViewById(R.id.textView7); break;
                case 100:sumaZatvori = findViewById(R.id.textView8); break;
                case 250:sumaZatvori = findViewById(R.id.textView9); break;
                case 500:sumaZatvori = findViewById(R.id.textView10); break;
                case 750:sumaZatvori = findViewById(R.id.textView11); break;
                case 1000:sumaZatvori = findViewById(R.id.textView12); break;
                case 2000:sumaZatvori = findViewById(R.id.textView13); break;
                case 3000:sumaZatvori = findViewById(R.id.textView14); break;
                case 4000:sumaZatvori = findViewById(R.id.textView15); break;
                case 5000:sumaZatvori = findViewById(R.id.textView16); break;
                case 10000:sumaZatvori = findViewById(R.id.textView17); break;
                case 20000:sumaZatvori = findViewById(R.id.textView18); break;
                case 35000:sumaZatvori = findViewById(R.id.textView19); break;
                case 100000:sumaZatvori = findViewById(R.id.textView20); break;
                case 250000:sumaZatvori = findViewById(R.id.textView21); break;
                case 1000000:sumaZatvori = findViewById(R.id.textView22); break;
                default:System.exit(0);break;
            }
            sumaZatvori.setVisibility(View.GONE);
            zatvori.setVisibility(View.GONE);
            niza[index]=0;
            int[] nova = new int[niza.length-1];
            int j = 0;
            for(int i = 0; i < niza.length; i++){
                if(niza[i] != 0){
                    nova[j] = niza[i];
                    j++;
                }
            }
            niza = nova;

            ponuda1++;
            if(ponuda1 < 5){
                if(ponuda1 == 4){
                    prikazi.setText("Отварате уште 1 кутија оваа рунда");
                }
                else {
                    prikazi.setText("Отварате уште " + (5 - ponuda1) + " кутии оваа рунда");
                }
            }
            else if(ponuda1==5){
                prikazi.setText("Отварате уште 3 кутии оваа рунда");
                pratiPonuda();
                ponuda1++;
            }
            else{
                ponuda2++;
                if(niza.length <= 2){
                    prikazi.setText("Последна рунда. Отворете ја кутијата што остана.");
                    pratiPonuda();

                }
                else if(ponuda2 < 3) {
                    if(ponuda2 == 1) {
                        prikazi.setText("Отварате уште " + (3 - ponuda2) + " кутии оваа рунда");
                    }
                    else{
                        prikazi.setText("Отварате уште 1 кутија оваа рунда");
                    }
                }
                else {
                    prikazi.setText("Отварате уште 3 кутии оваа рунда");
                    pratiPonuda();
                    ponuda2=0;
                }

            }

        }



    }

    public void pratiPonuda(){
        final TextView ponuda = findViewById(R.id.ponuda);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
        Button button13 = findViewById(R.id.button13);
        Button button14 = findViewById(R.id.button14);
        Button button15 = findViewById(R.id.button15);
        Button button16 = findViewById(R.id.button16);
        Button button17 = findViewById(R.id.button17);
        Button button18 = findViewById(R.id.button18);
        Button button19 = findViewById(R.id.button19);
        Button button20 = findViewById(R.id.button20);
        Button button21 = findViewById(R.id.button21);
        Button button22 = findViewById(R.id.button22);
        if(button1.getVisibility() == View.VISIBLE){button1.setVisibility(View.GONE);pomosna[0]=1;}
        if(button2.getVisibility() == View.VISIBLE){button2.setVisibility(View.GONE);pomosna[1]=1;}
        if(button3.getVisibility() == View.VISIBLE){button3.setVisibility(View.GONE);pomosna[2]=1;}
        if(button4.getVisibility() == View.VISIBLE){button4.setVisibility(View.GONE);pomosna[3]=1;}
        if(button5.getVisibility() == View.VISIBLE){button5.setVisibility(View.GONE);pomosna[4]=1;}
        if(button6.getVisibility() == View.VISIBLE){button6.setVisibility(View.GONE);pomosna[5]=1;}
        if(button7.getVisibility() == View.VISIBLE){button7.setVisibility(View.GONE);pomosna[6]=1;}
        if(button8.getVisibility() == View.VISIBLE){button8.setVisibility(View.GONE);pomosna[7]=1;}
        if(button9.getVisibility() == View.VISIBLE){button9.setVisibility(View.GONE);pomosna[8]=1;}
        if(button10.getVisibility() == View.VISIBLE){button10.setVisibility(View.GONE);pomosna[9]=1;}
        if(button11.getVisibility() == View.VISIBLE){button11.setVisibility(View.GONE);pomosna[10]=1;}
        if(button12.getVisibility() == View.VISIBLE){button12.setVisibility(View.GONE);pomosna[11]=1;}
        if(button13.getVisibility() == View.VISIBLE){button13.setVisibility(View.GONE);pomosna[12]=1;}
        if(button14.getVisibility() == View.VISIBLE){button14.setVisibility(View.GONE);pomosna[13]=1;}
        if(button15.getVisibility() == View.VISIBLE){button15.setVisibility(View.GONE);pomosna[14]=1;}
        if(button16.getVisibility() == View.VISIBLE){button16.setVisibility(View.GONE);pomosna[15]=1;}
        if(button17.getVisibility() == View.VISIBLE){button17.setVisibility(View.GONE);pomosna[16]=1;}
        if(button18.getVisibility() == View.VISIBLE){button18.setVisibility(View.GONE);pomosna[17]=1;}
        if(button19.getVisibility() == View.VISIBLE){button19.setVisibility(View.GONE);pomosna[18]=1;}
        if(button20.getVisibility() == View.VISIBLE){button20.setVisibility(View.GONE);pomosna[19]=1;}
        if(button21.getVisibility() == View.VISIBLE){button21.setVisibility(View.GONE);pomosna[20]=1;}
        if(button22.getVisibility() == View.VISIBLE){button22.setVisibility(View.GONE);pomosna[21]=1;}
        TextView prikazi = findViewById(R.id.prikazi);
        prikazi.setVisibility(View.INVISIBLE);
        ponuda.setVisibility(View.VISIBLE);
        final Button prifati = findViewById(R.id.prifati);
        final Button odbij = findViewById(R.id.odbij);
        zacuvaj = findViewById(R.id.buttonZacuvaj);
        zacuvajEdit = findViewById(R.id.editZacuvaj);
        prifati.setVisibility(View.VISIBLE);
        odbij.setVisibility(View.VISIBLE);


        if(niza.length == 17){
            int sumaGolemiKutii = 0;
            for(int i = 0; i < niza.length;i++){
                if(niza[i] > 750)sumaGolemiKutii += niza[i];
            }
            if(sumaGolemiKutii == 0){
                for(int i = 0; i < niza.length;i++){
                    if(niza[i] < 1000)sumaGolemiKutii += niza[i];
                }
            }
            presmetajSuma = (sumaGolemiKutii *0.3 )/(niza.length * 2 );
        }
        else if(niza.length == 14){
            int sumaGolemiKutii = 0;
            for(int i = 0; i < niza.length;i++){
                if(niza[i] > 750)sumaGolemiKutii += niza[i];
            }
            if(sumaGolemiKutii == 0){
                for(int i = 0; i < niza.length;i++){
                    if(niza[i] < 1000)sumaGolemiKutii += niza[i];
                }
            }
            presmetajSuma = (sumaGolemiKutii *0.35 )/(niza.length * 2 );
        }
        else if(niza.length == 11){
            int sumaGolemiKutii = 0;
            for(int i = 0; i < niza.length;i++){
                if(niza[i] > 750)sumaGolemiKutii += niza[i];
            }
            if(sumaGolemiKutii == 0){
                for(int i = 0; i < niza.length;i++){
                    if(niza[i] < 1000)sumaGolemiKutii += niza[i];
                }
            }
            presmetajSuma = (sumaGolemiKutii *0.5 )/(niza.length * 2 );
        }
        else if(niza.length == 8){
            int sumaGolemiKutii = 0;
            for(int i = 0; i < niza.length;i++){
                if(niza[i] > 750)sumaGolemiKutii += niza[i];
            }
            if(sumaGolemiKutii == 0){
                for(int i = 0; i < niza.length;i++){
                    if(niza[i] < 1000)sumaGolemiKutii += niza[i];
                }
            }
            presmetajSuma = (sumaGolemiKutii *0.7 )/(niza.length * 2 );
        }
        else if(niza.length == 5){
            int sumaGolemiKutii = 0;
            for(int i = 0; i < niza.length;i++){
                if(niza[i] > 750)sumaGolemiKutii += niza[i];
            }
            if(sumaGolemiKutii == 0){
                for(int i = 0; i < niza.length;i++){
                    if(niza[i] < 1000)sumaGolemiKutii += niza[i];
                }
            }
            presmetajSuma = (sumaGolemiKutii *0.9 )/(niza.length * 2 );
        }
        else if(niza.length == 2){
            int sumaGolemiKutii = 0;
            for(int i = 0; i < niza.length;i++){
                if(niza[i] > 750)sumaGolemiKutii += niza[i];
            }
            if(sumaGolemiKutii == 0){
                for(int i = 0; i < niza.length;i++){
                    if(niza[i] < 1000)sumaGolemiKutii += niza[i];
                }
            }
            presmetajSuma = (sumaGolemiKutii *1.3 )/(niza.length * 2 );
        }





        if(runda ==  6){
            Button mojaKutija = findViewById(R.id.mojaKutija);
            int index = (int)((Math.random()*niza.length));
            presmetajSuma = niza[index];
            SharedPreferences sp = getSharedPreferences("rekord", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            int prethodna = sp.getInt("rekord", 0);
            if(prethodna < presmetajSuma){
                editor.putInt("rekord", ((int)presmetajSuma));
                editor.apply();
            }
            ponuda.setText("Во вашата кутија има "+(int)presmetajSuma+" денари");
            prifati.setVisibility(View.GONE);
            odbij.setVisibility(View.GONE);


            if(save) {
                zacuvaj.setVisibility(View.VISIBLE);
                zacuvajEdit.setVisibility(View.VISIBLE);
                mojaKutija.setVisibility(View.INVISIBLE);

                zacuvaj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {// presmetajSuma se osvoenite pari
                        //ace peder
                        String name = zacuvajEdit.getText().toString();
                        ContentValues values = new ContentValues();
                        values.put(COLUMN_NAME, name);
                        values.put(COLUMN_DATE, String.valueOf(Calendar.getInstance().getTime()));
                        values.put(COLUMN_SCORE, Integer.toString((int) presmetajSuma));
                        getContentResolver().insert(Contract.CONTENT_URI, values);

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                finish();
                            }
                        }, 1500);
                    }
                });
            }else{
                mojaKutija.setVisibility(View.INVISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finish();
                    }
                }, 1500);
            }
        }
        if((runda != 6)&&(flag==0)) {
            ponuda.setText("Понудата на банкарот изнесува " + ((int) (presmetajSuma)) + " денари");
        }


    }

    public void prifati(View view){
        Button mojaKutija = findViewById(R.id.mojaKutija);
        runda++;
        TextView ponuda = findViewById(R.id.ponuda);
        int index = (int)((Math.random()*niza.length));
        int suma = niza[index];

        SharedPreferences sp = getSharedPreferences("rekord", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        int prethodna = sp.getInt("rekord", 0);
        if(prethodna < presmetajSuma){
            editor.putInt("rekord", ((int)presmetajSuma));
            editor.apply();
        }



        final Button prifati = findViewById(R.id.prifati);
        final Button odbij = findViewById(R.id.odbij);

        ponuda.setText("Во вашата кутија имаше "+suma+" денари и ја продадовте за "+((int)(presmetajSuma))+" денари");
        prifati.setVisibility(View.GONE);
        odbij.setVisibility(View.GONE);


        if(save){
            zacuvaj.setVisibility(View.VISIBLE);
            zacuvajEdit.setVisibility(View.VISIBLE);
            mojaKutija.setVisibility(View.INVISIBLE);

            zacuvaj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {//presmetajSuma se osvoenite pari
                    // veles selo najgolemoooo
                    String name=zacuvajEdit.getText().toString();
                    ContentValues values = new ContentValues();
                    values.put(COLUMN_NAME, name);
                    values.put(COLUMN_DATE, String.valueOf(Calendar.getInstance().getTime()));
                    values.put(COLUMN_SCORE, Integer.toString((int)presmetajSuma));
                    getContentResolver().insert(Contract.CONTENT_URI, values);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            finish();
                        }
                    }, 1500);
                }
            });
        }else{
            mojaKutija.setVisibility(View.INVISIBLE);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    finish();
                }
            }, 1500);
        }

    }
    public void odbij(View view){
        runda++;
        TextView ponuda = findViewById(R.id.ponuda);
        ponuda.setVisibility(View.GONE);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
        Button button13 = findViewById(R.id.button13);
        Button button14 = findViewById(R.id.button14);
        Button button15 = findViewById(R.id.button15);
        Button button16 = findViewById(R.id.button16);
        Button button17 = findViewById(R.id.button17);
        Button button18 = findViewById(R.id.button18);
        Button button19 = findViewById(R.id.button19);
        Button button20 = findViewById(R.id.button20);
        Button button21 = findViewById(R.id.button21);
        Button button22 = findViewById(R.id.button22);
        if(pomosna[0]==1)button1.setVisibility(View.VISIBLE);
        if(pomosna[1]==1)button2.setVisibility(View.VISIBLE);
        if(pomosna[2]==1)button3.setVisibility(View.VISIBLE);
        if(pomosna[3]==1)button4.setVisibility(View.VISIBLE);
        if(pomosna[4]==1)button5.setVisibility(View.VISIBLE);
        if(pomosna[5]==1)button6.setVisibility(View.VISIBLE);
        if(pomosna[6]==1)button7.setVisibility(View.VISIBLE);
        if(pomosna[7]==1)button8.setVisibility(View.VISIBLE);
        if(pomosna[8]==1)button9.setVisibility(View.VISIBLE);
        if(pomosna[9]==1)button10.setVisibility(View.VISIBLE);
        if(pomosna[10]==1)button11.setVisibility(View.VISIBLE);
        if(pomosna[11]==1)button12.setVisibility(View.VISIBLE);
        if(pomosna[12]==1)button13.setVisibility(View.VISIBLE);
        if(pomosna[13]==1)button14.setVisibility(View.VISIBLE);
        if(pomosna[14]==1)button15.setVisibility(View.VISIBLE);
        if(pomosna[15]==1)button16.setVisibility(View.VISIBLE);
        if(pomosna[16]==1)button17.setVisibility(View.VISIBLE);
        if(pomosna[17]==1)button18.setVisibility(View.VISIBLE);
        if(pomosna[18]==1)button19.setVisibility(View.VISIBLE);
        if(pomosna[19]==1)button20.setVisibility(View.VISIBLE);
        if(pomosna[20]==1)button21.setVisibility(View.VISIBLE);
        if(pomosna[21]==1)button22.setVisibility(View.VISIBLE);
        TextView prikazi = findViewById(R.id.prikazi);
        Button prifati = findViewById(R.id.prifati);
        Button odbij = findViewById(R.id.odbij);
        prifati.setVisibility(View.GONE);
        odbij.setVisibility(View.GONE);
        prikazi.setVisibility(View.VISIBLE);

    }




    public void otvori1(View view){
        Button zatvori = findViewById(R.id.button1);
        otvoriKutija(zatvori, 1);
        pomosna[0]=0;
    }

    public void otvori2(View view){
        Button zatvori = findViewById(R.id.button2);
        otvoriKutija(zatvori, 2);
        pomosna[1]=0;
    }

    public void otvori3(View view){
        Button zatvori = findViewById(R.id.button3);
        otvoriKutija(zatvori, 3);
        pomosna[2]=0;
    }

    public void otvori4(View view){
        Button zatvori = findViewById(R.id.button4);
        otvoriKutija(zatvori, 4);
        pomosna[3]=0;
    }

    public void otvori5(View view){
        Button zatvori = findViewById(R.id.button5);
        otvoriKutija(zatvori, 5);
        pomosna[4]=0;
    }

    public void otvori6(View view){
        Button zatvori = findViewById(R.id.button6);
        otvoriKutija(zatvori, 6);
        pomosna[5]=0;
    }

    public void otvori7(View view){
        Button zatvori = findViewById(R.id.button7);
        otvoriKutija(zatvori, 7);
        pomosna[6]=0;
    }

    public void otvori8(View view) {
        Button zatvori = findViewById(R.id.button8);
        otvoriKutija(zatvori, 8);
        pomosna[7]=0;
    }

    public void otvori9(View view){
        Button zatvori = findViewById(R.id.button9);
        otvoriKutija(zatvori, 9);
        pomosna[8]=0;
    }

    public void otvori10(View view){
        Button zatvori = findViewById(R.id.button10);
        otvoriKutija(zatvori, 10);
        pomosna[9]=0;
    }

    public void otvori11(View view){
        Button zatvori = findViewById(R.id.button11);
        otvoriKutija(zatvori, 11);
        pomosna[10]=0;
    }

    public void otvori12(View view){
        Button zatvori = findViewById(R.id.button12);
        otvoriKutija(zatvori, 12);
        pomosna[11]=0;
    }

    public void otvori13(View view){
        Button zatvori = findViewById(R.id.button13);
        otvoriKutija(zatvori, 13);
        pomosna[12]=0;
    }

    public void otvori14(View view){
        Button zatvori = findViewById(R.id.button14);
        otvoriKutija(zatvori, 14);
        pomosna[13]=0;
    }

    public void otvori15(View view){
        Button zatvori = findViewById(R.id.button15);
        otvoriKutija(zatvori, 15);
        pomosna[14]=0;
    }

    public void otvori16(View view){
        Button zatvori = findViewById(R.id.button16);
        otvoriKutija(zatvori, 16);
        pomosna[15]=0;
    }

    public void otvori17(View view){
        Button zatvori = findViewById(R.id.button17);
        otvoriKutija(zatvori, 17);
        pomosna[16]=0;
    }

    public void otvori18(View view){
        Button zatvori = findViewById(R.id.button18);
        otvoriKutija(zatvori, 18);
        pomosna[17]=0;
    }

    public void otvori19(View view){
        Button zatvori = findViewById(R.id.button19);
        otvoriKutija(zatvori, 19);
        pomosna[18]=0;
    }

    public void otvori20(View view){
        Button zatvori = findViewById(R.id.button20);
        otvoriKutija(zatvori, 20);
        pomosna[19]=0;
    }

    public void otvori21(View view){
        Button zatvori = findViewById(R.id.button21);
        otvoriKutija(zatvori, 21);
        pomosna[20]=0;
    }

    public void otvori22(View view){
        Button zatvori = findViewById(R.id.button22);
        otvoriKutija(zatvori, 22);
        pomosna[21]=0;
    }

    public void nazad(View view){
        finish();
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
