package fisei.uta.edu.ec.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // recuperar los datos de la activity que se mantiene en el Intent
        Bundle extras = getIntent().getExtras();

        String userName = extras.getString("usernameExtra");
        String password = extras.getString("passwordExtra");

        textViewTitle = findViewById(R.id.textViewTitle);

        textViewTitle.setText("Usuario:" + userName + "     " + "Clave: " + password);
    }
}