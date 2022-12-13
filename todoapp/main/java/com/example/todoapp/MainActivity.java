package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView items;
    TextView text; //changed from EditText
    Button add_button;
    ArrayList<String> item_list;
    ArrayAdapter<String> items_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_button = findViewById(R.id.add_button);
        items = findViewById(R.id.items);
        text = findViewById(R.id.text); //moved from addItem()

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            } //removed View view in addItem()
        });

        item_list = new ArrayList<>();
        items_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, item_list);
        items.setAdapter(items_adapter);
        setUpListView();
    }

    private void setUpListView() {
        items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item_list.remove(i);
                Toast.makeText(getApplicationContext(), "Item Removed", Toast.LENGTH_LONG).show();
                items_adapter.notifyDataSetChanged();
            }
        });
    }

    private void addItem() {
        String detail = text.getText().toString();
        items_adapter.add(detail);
        text.setText(null);
    }
}