package ariaseta.imastudio.teskepribadianmbti;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ariasetasetiaalam on 12/18/15.
 */
public class DeskripsiKepribadianDetil extends Activity{

    String kode,k1,k2,k3,k4;
    TextView test,testLengkap;
    Character kode1,kode2,kode3,kode4;
    ImageView gambar;
    TextView sifat, saranp, saranf, partner, keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_kepribadian_detil);
        gambar = (ImageView) findViewById(R.id.gambar);
        sifat = (TextView) findViewById(R.id.sifat);
        saranp = (TextView) findViewById(R.id.saranp);
        saranf = (TextView) findViewById(R.id.saranf);
        partner = (TextView) findViewById(R.id.partner);
        keterangan = (TextView) findViewById(R.id.keterangan);

        Intent i = getIntent();
        kode = i.getStringExtra("kode");

        kode1= kode.charAt(0);
        kode2= kode.charAt(1);
        kode3= kode.charAt(2);
        kode4= kode.charAt(3);

        if(kode1 == 'i'){
            k1="Introvert";
        } else {
            k1="Extrovert";
        }

        if(kode2 == 's'){
            k2="Sensing";
        } else {
            k2="Intuitive";
        }

        if(kode3 == 't'){
            k3="Thinking";
        } else {
            k3="Feeling";
        }

        if(kode4 == 'j'){
            k4="Judging";
        } else {
            k4="Perceiving";
        }



        test = (TextView) findViewById(R.id.test);
        testLengkap = (TextView) findViewById(R.id.test_lengkap);


        testLengkap.setText(k1+" "+k2+" "+k3+" "+k4);
        test.setText(kode.toUpperCase());

        switch (kode){
            case"istj":
                gambar.setImageResource(R.drawable.istj);
                sifat.setText(R.string.istj_sifat);
                saranp.setText(R.string.istj_saranp);
                saranf.setText(R.string.istj_saranf);
                partner.setText(R.string.istj_partner);
                keterangan.setText(R.string.istj_ket);
                break;

            case"isfj":
                gambar.setImageResource(R.drawable.isfj);
                sifat.setText(R.string.isfj_sifat);
                saranp.setText(R.string.isfj_saranp);
                saranf.setText(R.string.isfj_saranf);
                partner.setText(R.string.isfj_partner);
                keterangan.setText(R.string.isfj_ket);
                break;

            case"istp":
                gambar.setImageResource(R.drawable.istp);
                sifat.setText(R.string.istp_sifat);
                saranp.setText(R.string.istp_saranp);
                saranf.setText(R.string.istp_saranf);
                partner.setText(R.string.istp_partner);
                keterangan.setText(R.string.istp_ket);
                break;

            case"isfp":
                gambar.setImageResource(R.drawable.isfp);
                sifat.setText(R.string.isfp_sifat);
                saranp.setText(R.string.isfp_saranp);
                saranf.setText(R.string.isfp_saranf);
                partner.setText(R.string.isfp_partner);
                keterangan.setText(R.string.isfp_ket);
                break;

            case"infj":
                gambar.setImageResource(R.drawable.infj);
                sifat.setText(R.string.infj_sifat);
                saranp.setText(R.string.infj_saranp);
                saranf.setText(R.string.infj_saranf);
                partner.setText(R.string.infj_partner);
                keterangan.setText(R.string.infj_ket);
                break;

            case"intj":
                gambar.setImageResource(R.drawable.intj);
                sifat.setText(R.string.intj_sifat);
                saranp.setText(R.string.intj_saranp);
                saranf.setText(R.string.intj_saranf);
                partner.setText(R.string.intj_partner);
                keterangan.setText(R.string.intj_ket);
                break;

            case"infp":
                gambar.setImageResource(R.drawable.infp);
                sifat.setText(R.string.infp_sifat);
                saranp.setText(R.string.infp_saranp);
                saranf.setText(R.string.infp_saranf);
                partner.setText(R.string.infp_partner);
                keterangan.setText(R.string.infp_ket);
                break;

            case"intp":
                gambar.setImageResource(R.drawable.intp);
                sifat.setText(R.string.intp_sifat);
                saranp.setText(R.string.intp_saranp);
                saranf.setText(R.string.intp_saranf);
                partner.setText(R.string.intp_partner);
                keterangan.setText(R.string.intp_ket);
                break;

            case"estp":
                gambar.setImageResource(R.drawable.estp);
                sifat.setText(R.string.estp_sifat);
                saranp.setText(R.string.estp_saranp);
                saranf.setText(R.string.estp_saranf);
                partner.setText(R.string.estp_partner);
                keterangan.setText(R.string.estp_ket);
                break;

            case"esfp":
                gambar.setImageResource(R.drawable.esfp);
                sifat.setText(R.string.esfp_sifat);
                saranp.setText(R.string.esfp_saranp);
                saranf.setText(R.string.esfp_saranf);
                partner.setText(R.string.esfp_partner);
                keterangan.setText(R.string.esfp_ket);
                break;

            case"enfp":
                gambar.setImageResource(R.drawable.enfp);
                sifat.setText(R.string.enfp_sifat);
                saranp.setText(R.string.enfp_saranp);
                saranf.setText(R.string.enfp_saranf);
                partner.setText(R.string.enfp_partner);
                keterangan.setText(R.string.enfp_ket);
                break;

            case"entp":
                gambar.setImageResource(R.drawable.entp);
                sifat.setText(R.string.entp_sifat);
                saranp.setText(R.string.entp_saranp);
                saranf.setText(R.string.entp_saranf);
                partner.setText(R.string.entp_partner);
                keterangan.setText(R.string.entp_ket);
                break;

            case"estj":
                gambar.setImageResource(R.drawable.estj);
                sifat.setText(R.string.estj_sifat);
                saranp.setText(R.string.estj_saranp);
                saranf.setText(R.string.estj_saranf);
                partner.setText(R.string.estj_partner);
                keterangan.setText(R.string.estj_ket);
                break;

            case"esfj":
                gambar.setImageResource(R.drawable.esfj);
                sifat.setText(R.string.esfj_sifat);
                saranp.setText(R.string.esfj_saranp);
                saranf.setText(R.string.esfj_saranf);
                partner.setText(R.string.esfj_partner);
                keterangan.setText(R.string.esfj_ket);
                break;

            case"enfj":
                gambar.setImageResource(R.drawable.enfj);
                sifat.setText(R.string.enfj_sifat);
                saranp.setText(R.string.enfj_saranp);
                saranf.setText(R.string.enfj_saranf);
                partner.setText(R.string.enfj_partner);
                keterangan.setText(R.string.enfj_ket);
                break;

            case"entj":
                gambar.setImageResource(R.drawable.entj);
                sifat.setText(R.string.entj_sifat);
                saranp.setText(R.string.entj_saranp);
                saranf.setText(R.string.entj_saranf);
                partner.setText(R.string.entj_partner);
                keterangan.setText(R.string.entj_ket);
                break;

        }




    }
}
