package uta.fisei.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessage = findViewById(R.id.textViewMessage);

        // obtener los datos de la activity pasada como parámetros
        Bundle bundle = getIntent().getExtras();

        String parameterResult = bundle.getString("result");
        textViewMessage.setText(parameterResult);

    }

    public void OnClickShowThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}