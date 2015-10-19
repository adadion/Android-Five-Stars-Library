/**
 * Created by angtrim on 12/09/15.
 *
 */
package angtrim.com.fivestarslibrary;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class FiveStarsDialog {
    private final static String DEFAULT_TITLE           = "Rate this app";
    private final static String DEFAULT_TEXT            = "How much do you love our app?";
    private static final int WELL_RATING_STARS_VALUE    = 4;
    private static final int BAD_RATING_STARS_VALUE     = 3;

    private final Context mContext;

    private String mTitle;
    private String mRateText;

    private Intent mWellRatingActionIntent;
    private Intent mBadRatingActionIntent;

    private RatingBar mRatingBar;
    private AlertDialog mAlertDialog;

    public FiveStarsDialog(@NonNull Context context){
        mContext = context;
    }

    private void build(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View mDialogView = inflater.inflate(R.layout.stars, null);

        String titleToAdd = (mTitle == null) ? DEFAULT_TITLE : mTitle;
        String textToAdd = (mRateText == null) ? DEFAULT_TEXT : mRateText;
        TextView mContentTextView = (TextView) mDialogView.findViewById(R.id.text_content);
        mContentTextView.setText(textToAdd);
        mRatingBar = (RatingBar) mDialogView.findViewById(R.id.ratingBar);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override public void onRatingChanged(RatingBar ratingBar, float ratingValue, boolean b) {
                if (ratingValue >= WELL_RATING_STARS_VALUE) {
                    startWellRatingIntent();
                } else {
                    startBadRatingIntent();
                }

                mAlertDialog.dismiss();
            }
        });

        mAlertDialog = builder.setTitle(titleToAdd).setView(mDialogView)
                .create();
    }

    private void startWellRatingIntent() {
        if (mBadRatingActionIntent == null) return;
        mContext.startActivity(mWellRatingActionIntent);
    }

    private void startBadRatingIntent() {
        if (mBadRatingActionIntent == null) return;
        mContext.startActivity(mBadRatingActionIntent);
    }

    public void show() {
        build();
        mAlertDialog.show();
    }

    public FiveStarsDialog title(String title) {
        this.mTitle = title;
        return this;
    }

    public FiveStarsDialog rateText(String rateText){
        this.mRateText = rateText;
        return this;
    }

    public FiveStarsDialog wellRatingIntent(Intent mWellRatingActionIntent) {
        this.mWellRatingActionIntent = mWellRatingActionIntent;
        return this;
    }

    public FiveStarsDialog badRatingIntent(Intent mBadRatingActionIntent) {
        this.mBadRatingActionIntent = mBadRatingActionIntent;
        return this;
    }
}
