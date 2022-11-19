package fisei.uta.edu.ec.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        //listViewData = (ListView) findViewById(R.id.listViewData);

        listViewData = findViewById(R.id.listViewData);

        // cargar datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, loadData());

        listViewData.setAdapter(adapter);

        listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelected = (String) listViewData.getAdapter().getItem(i);

//                Toast.makeText(getApplicationContext(), "Selecciono: " + itemSelected,
//                        Toast.LENGTH_LONG).show();

                // regresar al activity (SecondActivity) el item selecccionado
                Intent intent = new Intent();
                intent.setData(Uri.parse(itemSelected));
//                intent.setData(Uri.parse(itemSelected_2));

                // indicar al IDE que el activity se cierra correctamente
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }

    private List<String> loadData() {

        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            String item = "Numero: " + i;
            list.add(item);
        }
        return list;
    }
}