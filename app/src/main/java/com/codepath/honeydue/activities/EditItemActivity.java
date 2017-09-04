package com.codepath.honeydue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.codepath.honeydue.R;
import com.codepath.honeydue.models.HoneyDueItem;

public class EditItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    HoneyDueItem.Priority priority = HoneyDueItem.Priority.LOW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        HoneyDueItem item = (HoneyDueItem) getIntent().getSerializableExtra("item");
        EditText etItem = (EditText) findViewById(R.id.etItem);
        Spinner spinner = (Spinner) findViewById(R.id.editItemPrioritySpinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.priorities_array, android.R.layout.simple_spinner_item);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(spinnerAdapter.getPosition(item.getPriority().name()));

        etItem.setText(item.getName());
        etItem.setSelection(item.getName().length());

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

        EditText etItem = (EditText) findViewById(R.id.etItem);
        HoneyDueItem item = (HoneyDueItem) getIntent().getSerializableExtra("item");
        int position = getIntent().getIntExtra("itemPos", -1);
        Intent data = new Intent();

        item.setName(etItem.getText().toString());
        item.setPriority(priority);

        data.putExtra("item", item);
        data.putExtra("itemPos", position);

        setResult(RESULT_OK, data);
        this.finish();

    }

    public void onCancel(View view) {
        setResult(RESULT_CANCELED);
        this.finish();
    }

}
