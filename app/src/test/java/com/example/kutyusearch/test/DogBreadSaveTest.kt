package com.example.kutyusearch.test

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.example.kutyusearch.ui.breads.BreadsPresenter
import com.example.kutyusearch.utils.getDogBreadResult
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DogBreadSaveTest {

    lateinit var context: Context

    @Throws(Exception::class)
    @Before
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun test() {
        val wantedName = "Aegean"

        val bread = BreadsPresenter.saveBread(context, getDogBreadResult())

        Assert.assertNotNull(bread)
        Assert.assertEquals(bread?.name, wantedName)
    }

    @After
    fun tearDown() {
    }
}