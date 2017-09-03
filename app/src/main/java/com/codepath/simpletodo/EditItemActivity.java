package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String item = getIntent().getStringExtra("item");
        EditText etItem = (EditText) findViewById(R.id.etItem);

        etItem.setText(item);
        etItem.setSelection(item.length());

    }

    public void onSave(View view) {

        EditText etItem = (EditText) findViewById(R.id.etItem);
        int position = getIntent().getIntExtra("itemPos", -1);
        Intent data = new Intent();

        data.putExtra("item", etItem.getText().toString());
        data.putExtra("itemPos", position);

        setResult(RESULT_OK, data);
        this.finish();

    }

}
