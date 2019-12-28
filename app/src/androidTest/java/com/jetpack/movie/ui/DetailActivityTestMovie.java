package com.jetpack.movie.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.jetpack.movie.R;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.Serializable;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class DetailActivityTestMovie {

    @Rule
    public ActivityTestRule<DetailActivity> activityRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            MovieModel dummyMovie = new MovieModel("384018",
                    "keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
                    "Fast & Furious Presents: Hobbs & Shaw",
                    "2019-08-02",
                    "en",
                    6.5,
                    "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.");
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Bundle b = new Bundle();
            b.putSerializable(DetailActivity.OBJECT, (Serializable) dummyMovie);
            Intent intent = new Intent(targetContext, DetailActivity.class);
            intent.putExtras(b);
            intent.putExtra(DetailActivity.TAB_PAGE, "0");
            return intent;
        }
    };

    @Before
    public void setupUI() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadDetailInfo() {
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()));
        onView(withId(R.id.tvReleaseDate)).check(matches(isDisplayed()));
        onView(withId(R.id.tvLanguage)).check(matches(isDisplayed()));
        onView(withId(R.id.tvOverview)).check(matches(isDisplayed()));
    }

}