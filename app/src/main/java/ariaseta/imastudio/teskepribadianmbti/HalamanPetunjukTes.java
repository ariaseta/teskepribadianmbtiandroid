package ariaseta.imastudio.teskepribadianmbti;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by ariasetasetiaalam on 12/18/15.
 */
public class HalamanPetunjukTes extends Activity {
    Button btnMulaiTes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_petunjuk_tes);

        btnMulaiTes = (Button) findViewById(R.id.button);
        btnMulaiTes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HalamanTes.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(nextScreen);
    }
}
