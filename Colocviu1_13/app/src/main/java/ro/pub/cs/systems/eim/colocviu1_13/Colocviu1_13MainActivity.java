package ro.pub.cs.systems.eim.colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ro.pub.cs.systems.eim.colocviu1_13.general.Constants;

public class Colocviu1_13MainActivity extends AppCompatActivity {


    private Button button_east, button_west, button_north, button_south;
    private Button navigate_to_second;
    private TextView indications;



    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String actions =  indications.getText().toString();

            switch (view.getId()) {
                case R.id.button_east:
                    actions += ",East";
                    indications.setText(String.valueOf(actions));
                    break;
                case R.id.button_west:
                    actions += ",West";
                    indications.setText(String.valueOf(actions));
                    break;
                case R.id.button_north:
                    actions += ",North";
                    indications.setText(String.valueOf(actions));
                    break;
                case R.id.button_south:
                    actions += ",South";
                    indications.setText(String.valueOf(actions));
                    break;
            }
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.INDICATE_DIRECTION, indications.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.INDICATE_DIRECTION)) {
            indications.setText(savedInstanceState.getString(Constants.INDICATE_DIRECTION));
        } else {
            indications.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13);
        button_east = (Button) findViewById(R.id.button_east);
        button_east.setOnClickListener(buttonClickListener);

        button_west = (Button) findViewById(R.id.button_west);
        button_west.setOnClickListener(buttonClickListener);

        button_north = (Button) findViewById(R.id.button_north);
        button_north.setOnClickListener(buttonClickListener);

        button_south = (Button) findViewById(R.id.button_south);
        button_south.setOnClickListener(buttonClickListener);

        indications = (TextView) findViewById(R.id.indications);
        indications.setText("");

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.INDICATE_DIRECTION)) {
                indications.setText(savedInstanceState.getString(Constants.INDICATE_DIRECTION));
            } else {
                indications.setText("");
            }
        } else {
            indications.setText("");
        }
    }
}
