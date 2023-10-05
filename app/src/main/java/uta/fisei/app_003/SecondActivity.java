package uta.fisei.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextNumberOne;
    private EditText editTextNumberTwo;
    private TextView textViewResult;
    private Button buttonAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // refenciar las vistas (controles) de la UI
        editTextNumberOne = findViewById(R.id.editTextNumberOne);
        editTextNumberTwo = findViewById(R.id.editTextNumberTwo);
        textViewResult = findViewById(R.id.textViewResult);
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = editTextNumberOne.getText().toString();
                String numberTwo = editTextNumberTwo.getText().toString();

                int a = Integer.parseInt(numberOne);
                int b = Integer.parseInt(numberTwo);
                long add = a + b;

                String result = String.valueOf(add);
                textViewResult.setText(result);
            }
        });
    }

    public void onClickAdd(View view) {
        String numberOne = editTextNumberOne.getText().toString();
        String numberTwo = editTextNumberTwo.getText().toString();

        int a = Integer.parseInt(numberOne);
        int b = Integer.parseInt(numberTwo);
        long add = a + b;

        String result = String.valueOf(add);
        textViewResult.setText(result);
    }
}