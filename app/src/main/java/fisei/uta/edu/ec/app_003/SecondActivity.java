package fisei.uta.edu.ec.app_003;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

    private int code = 1;

    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            // comprobar si la ventana hija (ThirdActivity) se cerro correctamente
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                textViewTitle.setText(data.getDataString());
            }
        }
    });

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

//        startActivity(intent);

        // iniciar una actividad para regresar datos (forma antigua)
//        startActivityForResult(intent, code);

        // iniciar el activity que va a regresar datos (forma nueva)
        activityResult.launch(intent);
    }

    public void onClick_buttonFinish (View view) {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
/*
        if ((code == requestCode ) && (resultCode == RESULT_OK)) {
            textViewTitle.setText(data.getDataString());
        }

 */
    }
}