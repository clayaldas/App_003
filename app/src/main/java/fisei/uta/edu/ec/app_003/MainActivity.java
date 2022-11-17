package fisei.uta.edu.ec.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextPassword;
    private Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonOk = findViewById(R.id.buttonOk);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                if (userName.equals("user") && password.equals("user"))
                {
                    // mostrar una segunda pantalla
                    Intent intent = new Intent( MainActivity.this, SecondActivity.class);

                    // pasar información al activity
                    intent.putExtra("usernameExtra", userName);
                    intent.putExtra("passwordExtra", password);

                    startActivity(intent);
                    // finish();
                }
                else
                {
                    //  mostrar un mensaje
                    Toast.makeText(getApplicationContext(), "Usuario y/o clave son incorrectos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}