package com.codepath.honeydue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.codepath.honeydue.R;
import com.codepath.honeydue.models.HoneyDueItem;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        HoneyDueItem item = (HoneyDueItem) getIntent().getSerializableExtra("item");
        EditText etItem = (EditText) findViewById(R.id.etItem);

        etItem.setText(item.getName());
        etItem.setSelection(item.getName().length());

    }

    public void onSave(View view) {

        EditText etItem = (EditText) findViewById(R.id.etItem);
        HoneyDueItem item = (HoneyDueItem) getIntent().getSerializableExtra("item");
        int position = getIntent().getIntExtra("itemPos", -1);
        Intent data = new Intent();

        item.setName(etItem.getText().toString());

        data.putExtra("item", item);
        data.putExtra("itemPos", position);

        setResult(RESULT_OK, data);
        this.finish();

    }

}
