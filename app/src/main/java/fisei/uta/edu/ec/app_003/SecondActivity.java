package fisei.uta.edu.ec.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private Button buttonShowBrowser;
    private Button buttonCallPhoneNumber;
    private Button buttonShowActivity;
    private Button buttonFinish;

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

    public void onClick_buttonShowBrowser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    public void onClick_buttonCallPhoneNumber (View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +09930201510"));;
        startActivity(intent);
    }

    public void onClick_buttonShowActivity (View view) {
        //Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);

    }

    public void onClick_buttonFinish (View view) {
        finish();
    }
}