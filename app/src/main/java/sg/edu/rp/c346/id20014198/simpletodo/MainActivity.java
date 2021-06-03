package sg.edu.rp.c346.id20014198.simpletodo;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTodo;
    Button buttonAdd;
    Button buttonDelete;
    Button buttonClear;
    ArrayList<String> alTodo;
    ArrayAdapter<String> aaTodo;
    Spinner todoitems;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTodo = findViewById(R.id.eTodo);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonClear = findViewById(R.id.buttonClear);
        lv = findViewById(R.id.lv);
        todoitems = findViewById(R.id.todoitems);
        alTodo = new ArrayList<>();
        aaTodo = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,alTodo);
        lv.setAdapter(aaTodo);

        todoitems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        editTodo.setHint(getString(R.string.typenew));
                        buttonAdd.setEnabled(true);
                        buttonDelete.setEnabled(false);
                        break;
                    case 1:
                        editTodo.setHint(getString(R.string.typeint));
                        buttonDelete.setEnabled(true);
                        buttonAdd.setEnabled(false);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nTodo = editTodo.getText().toString();
                alTodo.add(nTodo);
                aaTodo.notifyDataSetChanged();
                editTodo.setText(null);
                Toast.makeText(MainActivity.this, "Task has been added", Toast.LENGTH_LONG).show();

            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alTodo.clear();

                Toast.makeText(MainActivity.this, "Task has been cleared", Toast.LENGTH_LONG).show();
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = Integer.parseInt(editTodo.getText().toString());
                alTodo.remove(pos);
                aaTodo.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Task has been deleted", Toast.LENGTH_LONG).show();
            }
        });



    }
}