package uta.fisei.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.app.UiAutomation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
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
        //return super.onCreateOptionsMenu(menu);
    }
}