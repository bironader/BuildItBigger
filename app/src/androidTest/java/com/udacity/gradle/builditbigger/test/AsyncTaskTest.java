package com.udacity.gradle.builditbigger.test;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndPointAsyncTask;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Biro on 8/6/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {


    @Test
    public void setup() throws ExecutionException, InterruptedException {

        EndPointAsyncTask endPointAsyncTask = new EndPointAsyncTask();

        String joke = endPointAsyncTask.execute().get();
        assertEquals("This is totally a funny joke",joke);
    }




}
