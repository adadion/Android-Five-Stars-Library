package angtrim.com.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import angtrim.com.fivestarslibrary.FiveStarsDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(this,"angelo.gallarello@gmail.com");
        fiveStarsDialog.setRateText("Your custom text")
                .setTitle("Your custom title")
                .setForceMode(true)
                .show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
