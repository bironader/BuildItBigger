package com.udacity.gradle.builditbigger.test;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndPointAsyncTask;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Biro on 8/6/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest implements EndPointAsyncTask.ResponseCallBack {


    @Test
    public void setup()  {

        EndPointAsyncTask endPointAsyncTask = new EndPointAsyncTask();
        endPointAsyncTask.setResponseCallBack(this);
        endPointAsyncTask.execute();
    }



    @Override
    public void onSuccess(String result) {

        assertEquals("This is totally a funny joke",result);
    }
}
