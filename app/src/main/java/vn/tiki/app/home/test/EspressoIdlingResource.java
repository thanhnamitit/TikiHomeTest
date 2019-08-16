package vn.tiki.app.home.test;


import androidx.test.espresso.IdlingResource;

public class EspressoIdlingResource {

    private static final String RESOURCE = "GLOBAL";

    private static SimpleCountingIdlingResource mCountingIdlingResource =
            new SimpleCountingIdlingResource(RESOURCE);

    public static void increment() {
        mCountingIdlingResource.increment();
    }

    public static void decrement() {
        mCountingIdlingResource.decrement();
    }

    public static void decreToZero() {
        mCountingIdlingResource.decreaseToZero();
    }

    public static IdlingResource getIdlingResource() {
        return mCountingIdlingResource;
    }
}