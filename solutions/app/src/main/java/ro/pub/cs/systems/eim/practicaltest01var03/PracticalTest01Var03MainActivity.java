package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int firstNumber = 0, secondNumber = 0, result = 0;
            EditText editText1 = (EditText)findViewById(R.id.number_1);
            EditText editText2 = (EditText)findViewById(R.id.number_2);
            EditText resultText = (EditText)findViewById(R.id.result);
            if(isStringInt(editText1.getText().toString()) && isStringInt(editText2.getText().toString()))
            {
                firstNumber = Integer.valueOf(editText1.getText().toString());
                secondNumber = Integer.valueOf(editText2.getText().toString());
            }
            else
                Toast.makeText(getApplicationContext(), "TEXTUL INTRODUS NU ESTE UN NUMAR INTREG.", Toast.LENGTH_LONG).show();

            switch(view.getId()) {
                case R.id.plus_button:
                    result = firstNumber + secondNumber;
                    resultText.setText(String.valueOf(firstNumber + " + " + secondNumber + " = " + result));
                    break;
                case R.id.minus_button:
                    result = firstNumber - secondNumber;
                    resultText.setText(String.valueOf(firstNumber + " - " + secondNumber + " = " + result));
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        EditText editText1 = (EditText)findViewById(R.id.number_1);
        EditText editText2 = (EditText)findViewById(R.id.number_2);

        Button plusButton = (Button)findViewById(R.id.plus_button);
        plusButton.setOnClickListener(buttonClickListener);
        Button minusButton = (Button)findViewById(R.id.minus_button);
        minusButton.setOnClickListener(buttonClickListener);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("number_1")) {
                editText1.setText(savedInstanceState.getString("number_1"));
            } else {
                editText1.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("number_2")) {
                editText2.setText(savedInstanceState.getString("number_2"));
            } else {
                editText2.setText(String.valueOf(0));
            }
        } else {
            editText1.setText(String.valueOf(0));
            editText2.setText(String.valueOf(0));
        }
    }
    public boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText editText1 = (EditText)findViewById(R.id.number_1);
        EditText editText2 = (EditText)findViewById(R.id.number_2);
        savedInstanceState.putString("number_1", editText1.getText().toString());
        savedInstanceState.putString("number_2", editText2.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        EditText editText1 = (EditText)findViewById(R.id.number_1);
        EditText editText2 = (EditText)findViewById(R.id.number_2);
        if (savedInstanceState.containsKey("number_1")) {
            editText1.setText(savedInstanceState.getString("number_1"));
            Toast.makeText(getApplicationContext(), editText1.toString() + " " + editText2.toString(), Toast.LENGTH_LONG).show();
        } else {
            editText1.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("number_2")) {
            editText2.setText(savedInstanceState.getString("number_2"));
        } else {
            editText2.setText(String.valueOf(0));
        }
    }
}