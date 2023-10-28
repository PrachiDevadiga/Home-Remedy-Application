package com.example.homeremedy;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class RemedyActivity extends AppCompatActivity {
    private TextView diseaseNameTextView;
    private ListView remediesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedy);

        // Get the disease name from the intent
        String diseaseName = getIntent().getStringExtra("diseaseName");

        // Initialize views
        diseaseNameTextView = findViewById(R.id.diseaseNameTextView);
        remediesListView = findViewById(R.id.remediesListView);

        // Set disease name
        diseaseNameTextView.setText(diseaseName);

        // Retrieve remedies for the specific disease from Firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference remediesRef = db.collection("Disease").document(diseaseName).collection("Remedies");
        remediesRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<Remedy> remedies = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    String remedyName = document.getString("name");
                    String remedyDescription = document.getString("description");

                    remedies.add(new Remedy(remedyName, remedyDescription));
                }

                // Create adapter for remedies
                //RemediesAdapter remediesAdapter = new RemediesAdapter(this, remedies);

                // Set adapter on ListView
                //remediesListView.setAdapter(remediesAdapter);
            } else {
                // Handle error
            }
        });
    }
}
