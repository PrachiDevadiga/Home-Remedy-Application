package com.example.homeremedy;

/*import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class DiseaseList extends AppCompatActivity {
    private ArrayList<Disease> diseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_list);

        diseases = new ArrayList<>();
        diseases.add(new Disease(R.drawable.anxiety, "Anxiety"));
        diseases.add(new Disease(R.drawable.asthma, "Asthma/Wheezing"));
        diseases.add(new Disease(R.drawable.acidity, "Acidity"));
        diseases.add(new Disease(R.drawable.badbreath, "Bad Breath"));
        diseases.add(new Disease(R.drawable.acne, "Acne"));
        diseases.add(new Disease(R.drawable.allergy, "Allergy"));
        // Add more diseases here

        // Sort the diseases alphabetically
        Collections.sort(diseases, (d1, d2) -> d1.getName().compareToIgnoreCase(d2.getName()));

        // Create the adapter
        DiseaseAdapter adapter = new DiseaseAdapter(this, diseases);

        // Get the ListView and set the adapter
        ListView listView = findViewById(R.id.diseaseList);
        listView.setAdapter(adapter);

        // Set item click listener to navigate to the remedy page
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Disease selectedDisease = diseases.get(position);
                Intent intent = new Intent(getApplicationContext(), RemedyActivity.class);
                intent.putExtra("diseaseName", selectedDisease.getName());
                startActivity(intent);
            }
        });
    }
}*/
import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;

        import com.google.firebase.firestore.CollectionReference;
        import com.google.firebase.firestore.FirebaseFirestore;
        import com.google.firebase.firestore.QueryDocumentSnapshot;
        import com.google.firebase.firestore.QuerySnapshot;

        import java.util.ArrayList;
        import java.util.Collections;

public class DiseaseList extends AppCompatActivity {

    private ArrayList<Disease> diseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_list);

        diseases = new ArrayList<>();
        diseases.add(new Disease(R.drawable.anxiety, "Anxiety"));
        diseases.add(new Disease(R.drawable.asthma, "Asthma/Wheezing"));
        diseases.add(new Disease(R.drawable.acidity, "Acidity"));
        diseases.add(new Disease(R.drawable.badbreath, "Bad Breath"));
        diseases.add(new Disease(R.drawable.acne, "Acne"));
        diseases.add(new Disease(R.drawable.allergy, "Allergy"));
        // Add more diseases here

        // Sort the diseases alphabetically
        //Collections.sort(diseases, String::compareToIgnoreCase);
        Collections.sort(diseases, (d1, d2) -> {
            String name1 = d1.getName();
            String name2 = d2.getName();

            if (name1 == null && name2 == null) {
                return 0; // Both names are null, consider them equal
            } else if (name1 == null) {
                return -1; // First name is null, consider it less than the second name
            } else if (name2 == null) {
                return 1; // Second name is null, consider it less than the first name
            } else {
                return name1.compareToIgnoreCase(name2); // Compare non-null names
            }
        });

        // Create the adapter
        DiseaseAdapter adapter = new DiseaseAdapter(this, diseases);

        // Get the ListView and set the adapter
        ListView listView = findViewById(R.id.diseaseList);
        listView.setAdapter(adapter);

        // Set item click listener to navigate to the remedy page
        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            Disease selectedDisease = diseases.get(position);
            Intent intent = new Intent(DiseaseList.this, RemedyActivity.class);
            intent.putExtra("diseaseName", selectedDisease.getName());
            startActivity(intent);
        });
    }
}
