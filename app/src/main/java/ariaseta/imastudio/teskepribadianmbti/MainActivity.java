package ariaseta.imastudio.teskepribadianmbti;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends Activity {

    Context context = this;


    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void mainMenu(View v) {
        //aktifkan efek klik dari imageview
        v.startAnimation(buttonClick);
        switch (v.getId()) {
            case R.id.button_mulai:
                startActivity(new Intent(getApplicationContext(), HalamanPetunjukTes.class));
                break;

            case R.id.button_hasil_tes:
                startActivity(new Intent(getApplicationContext(), HasilTes.class));
                break;

            case R.id.button_deskripsi:
                startActivity(new Intent(getApplicationContext(), DeskripsiKepribadian
                        .class));
                break;

        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }



}
