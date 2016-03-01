package ariaseta.imastudio.teskepribadianmbti;

/**
 * Created by ariasetasetiaalam on 12/18/15.
 */
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.Window;
import android.widget.Toast;

import java.util.Objects;


public class SplashScreen extends Activity {
    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean paused = false;
    private String toast_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash_screen);

        Thread mythread = new Thread(){
            public void run(){
                try {
                    while (splashActive && ms < splashTime) {
                        if (!paused)
                            ms = ms + 100;
                        //toast_toast= Objects.toString(ms,null);
                        //Toast.makeText(getApplicationContext(),toast_toast, Toast.LENGTH_LONG).show();
                        sleep(100);
                    }
                }

                catch(Exception e){

                }

                finally {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
        mythread.start();
    }
}
