package uta.fisei.app_003;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.UiAutomation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class FirstActivity extends AppCompatActivity {

    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editTextName = findViewById(R.id.editTextName);

        registerForContextMenu(editTextName);
    }

    public void onClickButtonBrowser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    public void onClickButtonCallPhone (View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+593958"));
        startActivity(intent);
    }

    public void onClickButtonGoogleMaps (View view) {

        Uri uri = Uri.parse("geo:37.2202, -100.202");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

      //intent.setPackage("com.google.android.apps.maps");

        /*
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "No se puede mostrar el mapa",
                    Toast.LENGTH_SHORT).show();
        }

*/

    }
    public void onClickShowMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_principal, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        int id = item.getItemId();

        /*
        if (id == R.id.menuAbout) {
            Toast.makeText(this, "Bienvendido a la App", Toast.LENGTH_SHORT).show();
        }
         */


        switch (id) {
            case R.id.menuEditPaste:
                Toast.makeText(this, "Presiono en la opción Pegar", Toast.LENGTH_SHORT).show();
            case R.id.menuAbout:
                Toast.makeText(this, "Bienvendido a la App", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuFinish:
                finish();
                break;
        }



        //return true;
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_contextual, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuContextualEditCopy:
                Toast.makeText(this, "Presiono en Copiar", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}