package com.example.testout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NaiveBayesTool naiveBayesTool = new NaiveBayesTool(this);
        // yes 步行  No车  a高 b正常  c低
        String youth_medium_yes_fair = naiveBayesTool.naiveBayesClassificate("a c b b");
    }

    public String getData(){
        return "1425000000000000000000000000000000000000000000";
    }
}