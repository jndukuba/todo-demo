package com.codepath.honeydue.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.codepath.honeydue.R;
import com.codepath.honeydue.models.HoneyDueItem;

public class NewItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    HoneyDueItem.Priority priority = HoneyDueItem.Priority.LOW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        Spinner spinner = (Spinner) findViewById(R.id.newItemPrioritySpinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.priorities_array, android.R.layout.simple_spinner_item);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedPriority = (String) adapterView.getItemAtPosition(i);
        priority = HoneyDueItem.Priority.valueOf(selectedPriority.toUpperCase());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onSave(View view) {

        EditText etItem = (EditText) findViewById(R.id.nameEditTextView);
        Spinner spinner = (Spinner) findViewById(R.id.newItemPrioritySpinner);
        HoneyDueItem item = new HoneyDueItem();
        Intent data = new Intent();

        item.setName(etItem.getText().toString());
        item.setPriority(priority);

        data.putExtra("item", item);

        setResult(RESULT_OK, data);
        this.finish();

    }

    public void onCancel(View view) {
        setResult(RESULT_CANCELED);
        this.finish();
    }

}
