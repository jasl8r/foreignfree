package com.example.foreignfree

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

import uniffi.foreignfree.*
import uniffi.foreignfree.ForeignTrait

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun asyncCallAsync() {
        class Foreign: ForeignTrait {
            override suspend fun onAsync() {
                println("onAsync")
            }
        }

        var foreign = Foreign()
        var runner = Runner()

        runBlocking {
            runner.run(foreign)
        }
    }
}