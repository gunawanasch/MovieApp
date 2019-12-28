package com.jetpack.movie.ui;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.jetpack.movie.R;
import com.jetpack.movie.testing.SingleFragmentActivity;
import com.jetpack.movie.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TVShowFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TVShowFragment tvShowFragment = new TVShowFragment();

    @Before
    public void setupUI() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(tvShowFragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadTVShows() {
        onView(withId(R.id.rv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
//        onView(withId(R.id.rv)).check(matches(isDisplayed()));
    }
}