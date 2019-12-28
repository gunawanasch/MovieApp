package com.jetpack.movie.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.jetpack.movie.R;
import com.jetpack.movie.model.TVShowModel;
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

public class DetailActivityTestTVShow {

    @Rule
    public ActivityTestRule<DetailActivity> activityRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            TVShowModel dummyTV = new TVShowModel("12971",
                    "lCvOCn1Hq0ugBL6T8SyMoaCWNOc.jpg",
                    "Dragon Ball Z",
                    "1989-04-26",
                    "ja",
                    8.0,
                    "Five years have passed since the fight with Piccolo Jr. and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.");
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Bundle b = new Bundle();
            b.putSerializable(DetailActivity.OBJECT, (Serializable) dummyTV);
            Intent intent = new Intent(targetContext, DetailActivity.class);
            intent.putExtras(b);
            intent.putExtra(DetailActivity.TAB_PAGE, "1");
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