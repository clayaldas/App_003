package fisei.uta.edu.ec.app_003;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
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

        // menu contextual
        // asociar el menu contextual con un View (control: editTextPassword)
        registerForContextMenu(editTextPassword);

        getSupportActionBar().setTitle("Usuario conectado" + R.string.app_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId()) {
            case R.id.menu_insert:
                Toast.makeText(this, "Presiono en: Insertar", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_delete:
                Toast.makeText(this, "Presiono en: Eliminar", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_update:
                Toast.makeText(this, "Presiono en: Modificar", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_search:
                Toast.makeText(this, "Presiono en: buscar", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_open:
                Intent intent = new Intent(this, FourthActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_edit_copy:
                Toast.makeText(this, "Presiono en: copiar", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
        //return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Menu Contextual");

        // mostrar el menu contextual en el activity actual
        getMenuInflater().inflate(R.menu.menu_contextual, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_contextual_cut:
                Toast.makeText(this, "Presiono en: cortar", Toast.LENGTH_LONG).show();
               break;

            case R.id.menu_contextual_copy:
                Toast.makeText(this, "Presiono en: copiar", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_contextual_paste:
                Toast.makeText(this, "Presiono en: pegar", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}