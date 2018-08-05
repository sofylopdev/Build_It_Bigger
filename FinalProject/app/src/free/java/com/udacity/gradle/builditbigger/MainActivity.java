package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingInterstitial();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!mInterstitial.isLoading()) {
            settingInterstitial();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if (mInterstitial.isLoaded()) {
            mInterstitial.show();
        } else {
            MainActivityFragment fragment = (MainActivityFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragment);
            fragment.tellJoke();
        }
    }

    private void settingInterstitial() {
        MobileAds.initialize(this,
                getString(R.string.mobile_ads_id));

        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitial.loadAd(adRequest);

        mInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.i("MainActivity: free", "Ad loaded");
            }

            @Override
            public void onAdClosed() {
                MainActivityFragment fragment = (MainActivityFragment)
                        getSupportFragmentManager().findFragmentById(R.id.fragment);
                fragment.jokeLoading(true, "");
                fragment.tellJoke();
            }
        });
    }
}
