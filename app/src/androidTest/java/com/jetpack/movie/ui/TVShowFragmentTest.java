package com.jetpack.movie.ui;

import androidx.test.rule.ActivityTestRule;

import com.jetpack.movie.R;
import com.jetpack.movie.testing.SingleFragmentActivity;
import com.jetpack.movie.utils.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TVShowFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TVShowFragment tvShowFragment = new TVShowFragment();

    @Before
    public void setupUI() {
        activityRule.getActivity().setFragment(tvShowFragment);
    }

    @Test
    public void loadTVShows() {
        onView(withId(R.id.rv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv)).check(new RecyclerViewItemCountAssertion(10));
    }
}