package com.example.homeremedy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.homeremedy.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyRemedy extends AppCompatActivity {
    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    EditText editTextDiseaseName;
    EditText editTextRemedy;
    ImageView enter,back;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_remedy);

        sharedPreferences = getSharedPreferences("Remedies", MODE_PRIVATE);

        back=findViewById(R.id.back);
        editTextDiseaseName = findViewById(R.id.editTextDiseaseName);
        editTextRemedy = findViewById(R.id.editTextRemedy);
        enter = findViewById(R.id.enter);
        listView = findViewById(R.id.list_item);
        items = new ArrayList<>();

        // Load the saved remedies from shared preferences
        Set<String> savedRemedies = sharedPreferences.getStringSet("remedies", new HashSet<>());
        items.addAll(savedRemedies);

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyRemedy.this, homeactivity.class);
                startActivity(intent);
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diseaseName = editTextDiseaseName.getText().toString();
                String remedy = editTextRemedy.getText().toString();

                if (diseaseName.isEmpty() || remedy.isEmpty()) {
                    Toast.makeText(MyRemedy.this, "Please enter a disease name and remedy", Toast.LENGTH_SHORT).show();
                } else {
                    String item = diseaseName + "\n" + remedy;
                    addItem(item);
                    editTextDiseaseName.setText("");
                    editTextRemedy.setText("");
                    makeToast("Your remedy has been successfully added: " + item);

                    // Save the updated remedies to shared preferences
                    Set<String> updatedRemedies = new HashSet<>(items);
                    sharedPreferences.edit().putStringSet("remedies", updatedRemedies).apply();
                }
            }
        });
    }


    public void addItem(String item) {
        items.add(item);
        adapter.notifyDataSetChanged();
    }

    private void makeToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}
