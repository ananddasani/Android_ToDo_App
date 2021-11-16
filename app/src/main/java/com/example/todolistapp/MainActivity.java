package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        //add item on button clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call the method to add items
                addItem(v);
            }
        });

        arrayList = new ArrayList<>();
        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        //set the adapter
        listView.setAdapter(ad);

        //long press to delete
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //context for toast
                Context context = getApplicationContext();
                Toast.makeText(context, "Item Removed", Toast.LENGTH_LONG).show();

                arrayList.remove(position);
                ad.notifyDataSetChanged();
                return true;
            }
        });
    }

    //Method to add items into ArrayList
    private void addItem(View v) {
        EditText fetchToDo = findViewById(R.id.fetchToDo);

        String itemByUser = fetchToDo.getText().toString();

        //if not null
        if(!(itemByUser.equals(""))){
            //add the item in array list
            ad.add(itemByUser);
            fetchToDo.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(), "Please Enter Text", Toast.LENGTH_SHORT).show();
        }
    }
}