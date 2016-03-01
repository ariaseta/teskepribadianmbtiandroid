package ariaseta.imastudio.teskepribadianmbti;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by ariasetasetiaalam on 12/18/15.
 */
public class HasilTes extends Activity{

    int introvert, sensing, thinking, judging, ekstrovert, intuition, feeling, perceiving;
    TextView debugger;
    TextView hasilTes;
    TextView deskripsiHasil;
    //String isiDeskripsiHasil[];
    TextView iPersen,ePersen,sPersen,nPersen,tPersen,fPersen,jPersen,pPersen;
    Button buttonDetil;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_tes);

        debugger = (TextView) findViewById(R.id.debugger);
        hasilTes = (TextView) findViewById(R.id.hasiltes);
        buttonDetil = (Button) findViewById(R.id.buttonDetil);
        deskripsiHasil = (TextView) findViewById(R.id.deskripsiHasil);
        iPersen = (TextView) findViewById(R.id.iPersen);
        ePersen = (TextView) findViewById(R.id.ePersen);
        sPersen = (TextView) findViewById(R.id.sPersen);
        nPersen = (TextView) findViewById(R.id.nPersen);
        tPersen = (TextView) findViewById(R.id.tPersen);
        fPersen = (TextView) findViewById(R.id.fPersen);
        jPersen = (TextView) findViewById(R.id.jPersen);
        pPersen = (TextView) findViewById(R.id.pPersen);


        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        bikinDialog();

        introvert = prefs.getInt("introvert", 0);
        ekstrovert = prefs.getInt("ekstrovert", 0);
        sensing = prefs.getInt("sensing", 0);
        thinking = prefs.getInt("thinking", 0);
        judging = prefs.getInt("judging", 0);
        intuition = prefs.getInt("intuition", 0);
        feeling = prefs.getInt("feeling", 0);
        perceiving = prefs.getInt("perceiving",0);
        final int totalSoal= introvert+ekstrovert+sensing+thinking+judging+intuition+feeling+perceiving;

        if (totalSoal==0){
            dialogBelumTes();
        }

        final String hasil = cekHasilFinal();

        debugger.setText("I="+introvert+" "+ekstrovert+" "+sensing+" "+thinking+" "+judging+" "+intuition+" "+feeling+" "+perceiving+" TOTAL="+totalSoal+" HASIL="+hasil);
        hasilTes.setText(hasil.toUpperCase());
        deskripsiHasil.setText(cekDeskripsi(hasil));

        buttonDetil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goDetil = new Intent(getApplicationContext(),DeskripsiKepribadianDetil.class);
                goDetil.putExtra("kode",hasil);

                startActivity(goDetil);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(nextScreen);
    }

    public String cekHasilFinal(){
        String hasil;

        iPersen.setText(hitung(introvert));
        ePersen.setText(hitung(ekstrovert));
        sPersen.setText(hitung(sensing));
        nPersen.setText(hitung(intuition));
        tPersen.setText(hitung(thinking));
        fPersen.setText(hitung(feeling));
        jPersen.setText(hitung(judging));
        pPersen.setText(hitung(perceiving));

        if (introvert>=ekstrovert){
            hasil="i";
            iPersen.setTypeface(null, Typeface.BOLD);
        } else {
            hasil="e";
            ePersen.setTypeface(null, Typeface.BOLD);
        }

        if (sensing>=intuition){
            hasil=hasil+"s";
            sPersen.setTypeface(null, Typeface.BOLD);
        } else {
            hasil=hasil+"n";
            nPersen.setTypeface(null, Typeface.BOLD);
        }

        if (thinking>=feeling){
            hasil=hasil+"t";
            tPersen.setTypeface(null, Typeface.BOLD);
        } else {
            hasil=hasil+"f";
            fPersen.setTypeface(null, Typeface.BOLD);
        }

        if (judging>=perceiving){
            hasil=hasil+"j";
            jPersen.setTypeface(null, Typeface.BOLD);
        } else{
            hasil=hasil+"p";
            pPersen.setTypeface(null, Typeface.BOLD);
        }

        return hasil;
    }

    public String cekDeskripsi(String kode){
        String returnHore = null;

        switch (kode){
            case "istj" :
                returnHore="Bertanggungjawab";
                break;

            case "isfj" :
                returnHore="Setia";
                break;

            case "istp" :
                returnHore="Pragmatis";
                break;

            case "isfp" :
                returnHore="Artistik";
                break;

            case "infj" :
                returnHore="Reflektif";
                break;

            case "intj" :
                returnHore="Independen";
                break;

            case "infp" :
                returnHore="Idealis";
                break;

            case "intp" :
                returnHore="Konseptual";
                break;

            case "estp" :
                returnHore="Spontan";
                break;

            case "esfp" :
                returnHore="Murah Hati";
                break;

            case "enfp" :
                returnHore="Optimis";
                break;

            case "entp" :
                returnHore="Inovatif - Kreatif";
                break;

            case "estj" :
                returnHore="Konservatif - Disiplin";
                break;

            case "esf" :
                returnHore="Harmoni";
                break;

            case "enfj" :
                returnHore="Meyakinkan";
                break;

            case "entj" :
                returnHore="Pemimpin Alami";
                break;

            default:
                returnHore="Great!";


        }


       return returnHore;
    }

    public String hitung(int angka){

        double gogo = Double.valueOf(String.valueOf(angka))*100;
        double persentase = gogo/15;

        return Math.ceil(persentase)+"%";
    }

    public void bikinDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Anda belum pernah melakukan tes, apakah anda ingin tes sekarang?");

        alertDialogBuilder.setNegativeButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(),HalamanPetunjukTes.class);
                startActivity(i);
            }

        });

        alertDialogBuilder.setPositiveButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }

        });

        alertDialog = alertDialogBuilder.create();

    }

    public void dialogBelumTes() {
        alertDialog.show();

    }
}
