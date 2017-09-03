package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;

    private final int REQUEST_CODE = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvItems);
        readItems();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
    }

    public void onAddItem(View view) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( resultCode == RESULT_OK && requestCode == REQUEST_CODE ) {

            String item = data.getStringExtra( "item" );
            int position = data.getIntExtra( "itemPos", 0 );

            if( position > -1 ) {
                items.set(position, item);
                itemsAdapter.notifyDataSetChanged();
                writeItems();
            }

        }
    }

    private void setupListViewListener() {

        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        items.remove(i);
                        itemsAdapter.notifyDataSetChanged();
                        writeItems();
                        return true;
                    }
                });

        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent editIntent = new Intent(MainActivity.this, EditItemActivity.class);
                        editIntent.putExtra("item", items.get(i));
                        editIntent.putExtra("itemPos", i);
                        startActivityForResult(editIntent, REQUEST_CODE);
                    }
                }
        );

    }

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File( filesDir, "todo.txt" );
        try {
            items = new ArrayList<>(FileUtils.readLines(todoFile));
        } catch (IOException e ){
            items = new ArrayList<>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File( filesDir, "todo.txt" );
        try {
            FileUtils.writeLines( todoFile, items );
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
