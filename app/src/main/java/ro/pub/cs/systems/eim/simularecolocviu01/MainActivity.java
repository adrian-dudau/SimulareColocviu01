package ro.pub.cs.systems.eim.simularecolocviu01;

import android.app.Activity;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int but1_value = 0;
    private int but2_value = 0;

    private TextView text1;
    private TextView text2;

    private Button button1;
    private Button button2;
    private Button button3;

    private View.OnClickListener my_listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(Constants.LOG_TAG, "------------>> onCreate method was invoked");

        text1 = (TextView)findViewById(R.id.textView1);
        text2 = (TextView)findViewById(R.id.textView2);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.buttonSecondActivity);

        my_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        but1_value++;
                        text1.setText(Integer.toString(but1_value));
                        break;

                    case R.id.button2:
                        but2_value++;
                        text2.setText(Integer.toString(but2_value));
                        break;

                    case R.id.buttonSecondActivity:
                        Intent intent = new Intent(MainActivity.this, PracticalTest01SecondaryActivity.class);
                        intent.putExtra(Constants.INTENT_KEY_1, (but1_value + but2_value));
                        startActivityForResult(intent, Constants.SECOND_ACTIVITY_REQUESR_CODE);
                        break;
                }
            }
        };

        button1.setOnClickListener(my_listener);
        button2.setOnClickListener(my_listener);
        button3.setOnClickListener(my_listener);
    }

    /* Aici revin in activitatea principala cu rezultatele rularii*/
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case Constants.SECOND_ACTIVITY_REQUESR_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    Bundle data = intent.getExtras();
                }
                break;
        }
    }

    /* Astea sunt pentru a salava starea daca android elibereaza memoria aplicatiei */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Log.d(Constants.LOG_TAG, "------------>> onSaveInstanceState method was invoked");

        savedInstanceState.putInt(Constants.VALUE_1, but1_value);
        savedInstanceState.putInt(Constants.VALUE_1, but1_value);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(Constants.LOG_TAG, "------------>> onRestoreInstanceState method was invoked");

        but1_value = savedInstanceState.getInt(Constants.VALUE_1);
        but2_value = savedInstanceState.getInt(Constants.VALUE_2);

        text1.setText(Integer.toString(but1_value));
        text2.setText(Integer.toString(but2_value));
    }
}
