package dev.rulsoft.oprbattles

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

class ExampleInstrumentedTest {

    @get:Rule
    val composteTestRule = createComposeRule()

    @Test
    fun sampleTest(): Unit = with(composteTestRule){
        setContent {
            var text by remember { mutableStateOf("Hello") }
            Button(onClick = { text = "Goodbye" }) {
                Text(text = text)
            }
        }

        onNodeWithText("Hello").performClick()
        onRoot().printToLog("sampleTest")
        onNodeWithText("Goodbye").assertExists()
    }
}