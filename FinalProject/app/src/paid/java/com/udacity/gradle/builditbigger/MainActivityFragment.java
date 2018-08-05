package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sofialopes.android.jokedisplayandroid.JokeDisplayActivity;
import com.udacity.gradle.builditbigger.IdlingResource.SimpleIdlingResource;

import static android.view.View.GONE;
import static com.sofialopes.android.jokedisplayandroid.JokeDisplayActivity.JOKE_EXTRA;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AsyncGetJokes.LoadingJoke {

    private TextView instructions;
    private Button button;
    private ProgressBar progressBar;

    @Nullable
    private SimpleIdlingResource mIdlingResource;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        instructions = root.findViewById(R.id.instructions_text_view);
        button = root.findViewById(R.id.button_getjoke);
        progressBar = root.findViewById(R.id.progress_bar);

        return root;
    }

    public void tellJoke() {
        new AsyncGetJokes(this, mIdlingResource).execute();
    }

    @Override
    public void jokeLoading(boolean loading, String joke) {
        if (loading) {
            instructions.setVisibility(GONE);
            button.setVisibility(GONE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(GONE);

            Intent intent = new Intent(getContext(), JokeDisplayActivity.class);
            intent.putExtra(JOKE_EXTRA, joke);
            startActivity(intent);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        instructions.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
    }

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }
}