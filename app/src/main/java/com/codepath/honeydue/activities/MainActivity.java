package com.codepath.honeydue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.codepath.honeydue.R;
import com.codepath.honeydue.adapters.HoneyDueItemsAdapter;
import com.codepath.honeydue.models.HoneyDueItem;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<HoneyDueItem> items;
    HoneyDueItemsAdapter itemsAdapter;
    ListView lvItems;

    private final int REQUEST_CODE = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvItems);
        readItems();
        itemsAdapter = new HoneyDueItemsAdapter(this, items);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
    }

    public void onAddItem(View view) {

        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        HoneyDueItem item = new HoneyDueItem();

        item.setName(etNewItem.getText().toString());

        if( item.save() ) {
            etNewItem.setText("");
            itemsAdapter.add(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( resultCode == RESULT_OK && requestCode == REQUEST_CODE ) {

            HoneyDueItem item = (HoneyDueItem) data.getSerializableExtra( "item" );
            int position = data.getIntExtra( "itemPos", -1 );

            if( position > -1 ) {
                item.save();
                items.set(position, item);
                itemsAdapter.notifyDataSetChanged();
            }

        }
    }

    private void setupListViewListener() {

        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        HoneyDueItem item = items.get(i);
                        items.remove(i);
                        itemsAdapter.notifyDataSetChanged();
                        item.delete();
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
        items = SQLite.select().from(HoneyDueItem.class).queryList();
    }

}
