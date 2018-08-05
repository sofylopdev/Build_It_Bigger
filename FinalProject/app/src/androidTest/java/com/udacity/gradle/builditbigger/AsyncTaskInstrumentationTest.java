package com.udacity.gradle.builditbigger;

import android.test.ActivityInstrumentationTestCase2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class AsyncTaskInstrumentationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivityFragment mFragment;
    private String actual;

    public AsyncTaskInstrumentationTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        MainActivity mActivity = getActivity();

        mFragment = (MainActivityFragment) mActivity.getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
    }

    public void testPreconditions() {
        assertNotNull("mFragment is null", mFragment);
    }

    public void testAsyncTaskTest() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);

        final AsyncGetJokes myTask = new AsyncGetJokes(mFragment, null) {

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                actual = result;
                signal.countDown();
            }
        };

        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                myTask.execute();
            }
        });

        signal.await(30, TimeUnit.SECONDS);

        String expected = "";
        assertThat(actual, is(not(equalTo(expected))));
    }
}
