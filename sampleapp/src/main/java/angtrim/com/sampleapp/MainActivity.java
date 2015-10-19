package angtrim.com.sampleapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import angtrim.com.fivestarslibrary.FiveStarsDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        Intent wellIntent = new Intent(Intent.ACTION_VIEW);
        wellIntent.setData(Uri.parse("http://www.google.com"));

        Intent badIntent = new Intent(Intent.ACTION_VIEW);
        wellIntent.setData(Uri.parse("http://www.google.com"));

        FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(this);
        fiveStarsDialog.rateText("Your custom text")
            .title("Your custom title")
            .wellRatingIntent(wellIntent)
            .badRatingIntent(badIntent)
            .show();
    }

}
