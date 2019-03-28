package ro.pub.cs.systems.eim.simularecolocviu01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    private TextView text3;

    private Button buttonOk;
    private Button buttonCancel;

    private View.OnClickListener second_listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        final Intent receivedIntent = getIntent();
        int total = receivedIntent.getIntExtra(Constants.INTENT_KEY_1, 1);

        Log.d(Constants.LOG_TAG, "------------>> onCreate method was invoked" + Integer.toString(total));

        text3 = (TextView) findViewById(R.id.textView3);

        text3.setText(Integer.toString(total));

        buttonOk = (Button) findViewById(R.id.ok_button);
        buttonCancel = (Button) findViewById(R.id.cancel_button);

        second_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent;
                switch (v.getId()) {
                    case R.id.ok_button:
//                        returnIntent = new Intent();
//                        receivedIntent.putExtra(Constants.INTENT_KEY_1, "1");
                        setResult(RESULT_OK);
                        finish();
                        break;

                    case R.id.cancel_button:
//                        returnIntent = new Intent();
//                        receivedIntent.putExtra(Constants.INTENT_KEY_1, "0");
                        setResult(RESULT_CANCELED);
                        finish();
                        break;
                }
            }
        };

        buttonOk.setOnClickListener(second_listener);
        buttonCancel.setOnClickListener(second_listener);

    }
}
