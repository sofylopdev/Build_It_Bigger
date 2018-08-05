package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivity =
            new ActivityTestRule<>(MainActivity.class);

    private IdlingResource mIdlingResource;

    @Before
    public void registerIdlingResource() {
        mIdlingResource = ((MainActivityFragment)
                mActivity.getActivity()
                        .getSupportFragmentManager()
                        .findFragmentById(R.id.fragment))
                .getIdlingResource();
        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void testAsyncTask() {
        onView(withId(R.id.button_getjoke)).perform(click());
        onView(withId(R.id.joke_tv)).check(matches(not(withText(""))));
    }

    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }
}
