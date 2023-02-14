package com.example.sharepreferencevariables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
    }
    public void button(View view){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.putString("stringUserData", editText.getText().toString());
        editor.putString("stringProgrammingWorld", "This is programmingworld");
        editor.apply();
    }
    public void button3(View view){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String stringSharedPref_UserData = sharedPreferences.getString("StringUserData",null);
        String stringSharedPref_PWorld = sharedPreferences.getString("StringProgrammingWorld",null);

        if(stringSharedPref_PWorld == null &&
                stringSharedPref_UserData == null){
            textView.setText("Shared Preference Vaiables do not exist");
        }
        else{
            textView.setText(stringSharedPref_PWorld+"\n"+stringSharedPref_UserData);
        }
    }
    public void button4(View view){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }
    public void button5(View view){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        sharedPreferences.edit().remove("stringUserData").commit();
    }
}