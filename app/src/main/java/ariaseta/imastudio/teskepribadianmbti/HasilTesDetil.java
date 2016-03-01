package ariaseta.imastudio.teskepribadianmbti;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by ariasetasetiaalam on 12/18/15.
 */
public class HasilTesDetil extends Activity {

    String kode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_tes_detil);

        Intent  i = getIntent();
        kode = i.getStringExtra("kode");

    }
}