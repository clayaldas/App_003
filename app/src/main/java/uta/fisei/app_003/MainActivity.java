package uta.fisei.app_003;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewMessage;
    private int code = 1;

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            if (result.getResultCode() == Activity.RESULT_OK) {
                // obtener los datos regresados
                Intent data = result.getData();
                textViewMessage.setText(data.getDataString());
            }
        }
    });

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

        // startActivity(intent);
        //startActivityForResult( intent, code);
        resultLauncher.launch(intent);
    }

    /*
    @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == code) && (resultCode == RESULT_OK)) {
            textViewMessage.setText("Valor selecccionado:" + data.getDataString() );
        }
    }
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
}