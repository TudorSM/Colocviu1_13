package ro.pub.cs.systems.eim.colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ro.pub.cs.systems.eim.colocviu1_13.general.Constants;

public class Colocviu1_13SecondaryActivity extends AppCompatActivity {

    private TextView indications_received;
    private Button register_button, cancel_Button;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.register_button:
                    Intent intent = new Intent();
                    intent.putExtra("Cancel", "Register");
                    setResult(RESULT_OK, intent);
                    break;
                case R.id.cancel_button:
                    Intent intent2 = new Intent();
                    intent2.putExtra("Cancel", "Cancel");
                    setResult(RESULT_CANCELED, intent2);
                    break;
            }
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_secondary);
        indications_received = (TextView) findViewById(R.id.string_received);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.INDICATE_DIRECTION)) {
            String numberOfClicks = intent.getStringExtra(Constants.INDICATE_DIRECTION);
            indications_received.setText(String.valueOf(numberOfClicks));
        }

        register_button = (Button) findViewById(R.id.register_button);
        register_button.setOnClickListener(buttonClickListener);
        cancel_Button = (Button) findViewById(R.id.cancel_button);
        cancel_Button.setOnClickListener(buttonClickListener);
    }
}
