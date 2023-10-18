package uta.fisei.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private ListView listViewData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        listViewData = findViewById(R.id.listViewData);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, loadData());
        listViewData.setAdapter(adapter);


        // obtener el item seleccionado dentro del ListView
        listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelected = (String) listViewData.getAdapter().getItem(i);
                //Toast.makeText(getApplicationContext(), "Selecciono: " + itemSelected,
                  //      Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setData(Uri.parse(itemSelected));

                // comprobar que todo funcione de acuerdo a lo esperado
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

    }

    private List<String> loadData() {
        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= 20; i++) {
            String item = "Número:  " + i;
            list.add(item);
        }

        return list;
    }
}