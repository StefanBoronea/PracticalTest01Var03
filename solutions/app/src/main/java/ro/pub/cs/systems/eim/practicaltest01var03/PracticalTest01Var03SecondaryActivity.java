package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.correct_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.incorrect_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        TextView resultText = (TextView)findViewById(R.id.result2);
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        resultText.setText(result);

        Button correctButton = (Button)findViewById(R.id.correct_button);
        correctButton.setOnClickListener(buttonClickListener);
        Button incorrectButton = (Button)findViewById(R.id.incorrect_button);
        incorrectButton.setOnClickListener(buttonClickListener);
    }
}