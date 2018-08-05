package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.IdlingResource.SimpleIdlingResource;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


public class AsyncGetJokes extends AsyncTask<Void, Void, String> {

    private static MyApi myApiService = null;
    private LoadingJoke mCallback;
    private SimpleIdlingResource mIdlingResource;

    public interface LoadingJoke {
        void jokeLoading(boolean loading, String joke);
    }

    public AsyncGetJokes(LoadingJoke callback, @Nullable final SimpleIdlingResource idlingResource) {
        this.mCallback = callback;

        if (idlingResource != null) {
            idlingResource.setIdleState(false);
            mIdlingResource = idlingResource;
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCallback.jokeLoading(true, "");
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setRootUrl("http://192.168.1.76:8080/_ah/api/")
                    .setRootUrl("https://sofy-jokes-cloud.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }


        try {
            return myApiService.getJoke().execute().getMyJoke();
        } catch (IOException e) {
            Log.e("AsyncTask", e.getMessage());
            return "";
        }
    }

    @Override
    protected void onPostExecute(String joke) {

        if (mIdlingResource != null) {
            mIdlingResource.setIdleState(true);
        }

        mCallback.jokeLoading(false, joke);
    }
}