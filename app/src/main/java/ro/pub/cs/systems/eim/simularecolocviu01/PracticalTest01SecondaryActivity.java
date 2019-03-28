package ro.pub.cs.systems.eim.simularecolocviu01;

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

        Log.d(Constants.LOG_TAG, "------------>> onCreate method was invoked");

        text3 = (TextView) findViewById(R.id.textView3);

        buttonOk = (Button) findViewById(R.id.ok_button);
        buttonCancel = (Button) findViewById(R.id.cancel_button);

        second_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ok_button:
                        //
                        break;

                    case R.id.cancel_button:
                        //
                        break;
                }
            }
        };
    }
}
