package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * Created by moham on 5/14/2018.
 */
@RunWith(AndroidJUnit4.class)
public class JokeResultTest {


    @Rule
    public IntentsTestRule rule = new IntentsTestRule<>(MainActivity.class);


    @Test
    public void testJokeResult()
    {
        onView(withId(R.id.bt_showJoke)).perform(click());
        intended(hasExtra("joke","funny Joke"));
    }
}