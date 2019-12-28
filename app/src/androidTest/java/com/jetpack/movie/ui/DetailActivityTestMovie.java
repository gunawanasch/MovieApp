package com.jetpack.movie.ui;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.jetpack.movie.R;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.utils.FakeDataDummy;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityTestMovie {
    private MovieModel dummyMovie = FakeDataDummy.generateDummyMovie().get(0);

    @Rule
    public ActivityTestRule<DetailActivity> activityRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailActivity.class);
            result.putExtra(DetailActivity.ID_DATA, dummyMovie.getMovieId());
            result.putExtra(DetailActivity.TAB_PAGE, "0");
            return result;
        }
    };

    @Test
    public void loadDetailInfo() {
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie.getName())));
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRating)).check(matches(withText(String.valueOf(dummyMovie.getRating()))));
        onView(withId(R.id.tvReleaseDate)).check(matches(isDisplayed()));
        onView(withId(R.id.tvReleaseDate)).check(matches(withText(dummyMovie.getReleaseDate())));
        onView(withId(R.id.tvLanguage)).check(matches(isDisplayed()));
        onView(withId(R.id.tvLanguage)).check(matches(withText(String.valueOf(dummyMovie.getLanguage()))));
        onView(withId(R.id.tvOverview)).check(matches(isDisplayed()));
        onView(withId(R.id.tvOverview)).check(matches(withText(dummyMovie.getOverview())));
    }

}