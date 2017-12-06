package com.example.girish.shared_preference_example;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button count;
    int counter;
    int result;
    TextView setResult;
    EditText editValue;
    Context context= MainActivity.this;
    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";
    private static final String COUNT_KEY="countKey";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = (Button) findViewById(R.id.button);
        

         pref= context.getSharedPreferences(PREF_NAME, PRIVATE_MODE); // 0 - for private mode
         editor = pref.edit();

        count.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            counter++;
            saveData(counter);
        }
    });

    }
public void saveData(int countValue){

    editor.putInt(COUNT_KEY, countValue); // Storing integer
    editor.commit(); // commit changes
    retreiveData();

    }
public void retreiveData(){
    setResult=(TextView)findViewById(R.id.textView);
    result=pref.getInt(COUNT_KEY,0);
    setResult.setText(result+"");
}

}
