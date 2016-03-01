package ariaseta.imastudio.teskepribadianmbti;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;

/**
 * Created by ariasetasetiaalam on 12/18/15.
 */
public class DeskripsiKepribadian extends Activity {

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_kepribadian);
    }

    @Override
    public void onBackPressed() {
        Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(nextScreen);
    }

    public void menuKepri1(View v) {
        //aktifkan efek klik dari imageview
        v.startAnimation(buttonClick);
        switch (v.getId()) {
            case R.id.halBerikut:
                startActivity(new Intent(getApplicationContext(), DeskripsiKepribadian2.class));
                break;

            case R.id.istp:
                Intent nextScreen = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen.putExtra("kode","istp");
                startActivity(nextScreen);
                break;

            case R.id.isfp:
                Intent nextScreen2 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen2.putExtra("kode","isfp");
                startActivity(nextScreen2);
                break;

            case R.id.istj:
                Intent nextScreen3 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen3.putExtra("kode","istj");
                startActivity(nextScreen3);
                break;

            case R.id.isfj:
                Intent nextScreen4 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen4.putExtra("kode","isfj");
                startActivity(nextScreen4);
                break;

            case R.id.infp:
                Intent nextScreen5 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen5.putExtra("kode","infp");
                startActivity(nextScreen5);
                break;

            case R.id.intp:
                Intent nextScreen6 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen6.putExtra("kode","intp");
                startActivity(nextScreen6);
                break;

            case R.id.infj:
                Intent nextScreen7 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen7.putExtra("kode","infj");
                startActivity(nextScreen7);
                break;

            case R.id.intj:
                Intent nextScreen8 = new Intent(getApplicationContext(), DeskripsiKepribadianDetil.class);
                nextScreen8.putExtra("kode","intj");
                startActivity(nextScreen8);
                break;


        }
    }


}
