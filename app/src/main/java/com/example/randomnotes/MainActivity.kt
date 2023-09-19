package com.example.randomnotes

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.randomnotes.ui.theme.RandomNotesTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
        setContentView(R.layout.activity_main)
        val generateButton : Button = findViewById(R.id.button);
        generateButton.setOnClickListener(this::generateRandomNote)
    }

    private fun generateRandomNote(view: View?) {
        val chordTextView = findViewById<TextView>(R.id.chord)
        val noteTextView = findViewById<TextView>(R.id.note)
        val switchChord : Switch = findViewById(R.id.switch_chord)
        val switchNote : Switch = findViewById(R.id.switch_note)

        if(switchChord.isChecked) {
            val randomChord = generateRandomChord()
            chordTextView.text = randomChord
        }else{
            chordTextView.text = ""
        }
        if(switchNote.isChecked) {
            val randomNote = generateRandomNote()
            noteTextView.text = randomNote
        }else{
            noteTextView.text = ""
        }
    }

    private fun generateRandomChord(): String {
        val root = generateRandomNote()
        val switch7 : Switch = findViewById(R.id.switch7)
        val switch7Min : Switch = findViewById(R.id.switch7min)
        val switch7Maj : Switch = findViewById(R.id.switch7maj)
        val switchHalfDim : Switch = findViewById(R.id.switch_halfdim)
        val types = mutableListOf<String>()
        if(switch7.isChecked) {
            types.add("7")
        }
        if(switch7Min.isChecked) {
            types.add("-7")
        }
        if(switch7Maj.isChecked) {
            types.add("Δ7")
        }
        if(switchHalfDim.isChecked) {
            types.add("ø")
        }
        Log.d("types", types.toString())
        if(types.isEmpty()) {
            return ""
        }
        else {
            val type = types.random()
            return "$root$type"
        }
    }

    fun generateRandomNote(): String {
        val notes = listOf("A", "B", "C", "D", "E", "F", "G", "Ab", "Bb", "Db", "Eb", "Gb")
        val randomNote = notes.random()
        return randomNote
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RandomNotesTheme {
        Greeting("Android")
    }
}