package com.example.lab3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import android.widget.*;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> secretWords = new ArrayList(Arrays.asList("APPLE", "BANANA", "CHERRY"));
    String word = "";
    String shuffledWord = "";
    Random rand = new Random();
    int guesses = 0;
    String strInput;
    char charInput;
    String correctGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        String randElement = (secretWords.get(rand.nextInt(secretWords.size())));
        word = randElement;

        ArrayList<String> splitWord = new ArrayList(Arrays.asList(randElement.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord)
            shuffledWord += c;

        displayScrambledWord();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void displayScrambledWord(){
        TextView c = (TextView) findViewById(R.id.scrambledWord);
        c.setText(shuffledWord + " Number of Guesses: " + guesses);
    }

    public void guess(View v){
        EditText c = (EditText) findViewById(R.id.guessText);
        TextView j = (TextView) findViewById(R.id.correctlyGuessed);
        strInput = c.getText().toString();
        charInput = strInput.charAt(0);
        if(charInput == word.charAt(0)){
            correctGuess = correctGuess + String.valueOf(charInput);
            j.setText(correctGuess);
            word.substring(1);
            c.setText("");
        }
        else{
            guesses ++;
            c.setText("");
        }


    }

}
