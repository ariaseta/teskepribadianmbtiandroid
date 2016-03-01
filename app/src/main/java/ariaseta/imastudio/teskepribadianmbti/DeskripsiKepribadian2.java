package ariaseta.imastudio.teskepribadianmbti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

/**
 * Created by ariasetasetiaalam on 12/25/15.
 */
public class DeskripsiKepribadian2 extends Activity{

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_kepribadian_2);
    }

    @Override
    public void onBackPressed() {
        Intent nextScreen = new Intent(getApplicationContext(), DeskripsiKepribadian.class);
        startActivity(nextScreen);
    }

    public void menuKepri2(View v) {
        //aktifkan efek klik dari imageview
        v.startAnimation(buttonClick);
        switch (v.getId()) {
            case R.id.halSebelum:
                startActivity(new Intent(getApplicationContext(), DeskripsiKepribadian.class));
                break;

            case R.id.estp:
                Intent nextScreen = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen.putExtra("kode","estp");
                startActivity(nextScreen);
                break;

            case R.id.esfp:
                Intent nextScreen2 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen2.putExtra("kode","esfp");
                startActivity(nextScreen2);
                break;

            case R.id.estj:
                Intent nextScreen3 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen3.putExtra("kode","estj");
                startActivity(nextScreen3);
                break;

            case R.id.esfj:
                Intent nextScreen4 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen4.putExtra("kode","esfj");
                startActivity(nextScreen4);
                break;

            case R.id.enfp:
                Intent nextScreen5 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen5.putExtra("kode","enfp");
                startActivity(nextScreen5);
                break;

            case R.id.entp:
                Intent nextScreen6 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen6.putExtra("kode","entp");
                startActivity(nextScreen6);
                break;

            case R.id.enfj:
                Intent nextScreen7 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen7.putExtra("kode","enfj");
                startActivity(nextScreen7);
                break;

            case R.id.entj:
                Intent nextScreen8 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen8.putExtra("kode","entj");
                startActivity(nextScreen8);
                break;


        }
    }


}
