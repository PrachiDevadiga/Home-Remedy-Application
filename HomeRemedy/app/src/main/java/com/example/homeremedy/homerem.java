package com.example.homeremedy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class homerem extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list;
    private recycleradapter adapter;
    private List<remedies> remedyList;
    private SearchView searchView;
    private ImageView back;
    private Animation fadeInAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homerem);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle("Home Remedy");

        back=findViewById(R.id.back);
        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);


        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchRemedies(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //  filterList(newText);
                searchRemedies(newText);
                return true;
            }
        });
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.startAnimation(fadeInAnimation);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        list= Arrays.asList(getResources().getStringArray(R.array.android_versions));
        adapter=new recycleradapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        initData();
        setRecyclerView();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homerem.this, homeactivity.class);
                startActivity(intent);
            }
        });
    }


    /*private void setRecyclerView() {
        remediesAdapter remediesAdapter=new  remediesAdapter(remedyList);

       // recyclerView.setAdapter(remedyadapter);
        recyclerView.setAdapter(remediesAdapter);
        recyclerView.setHasFixedSize(true);
    }*/
    private void setRecyclerView() {
        initData();  // Initialize remedyList
        remedyadapter remediesAdapter = new remedyadapter(remedyList);
        recyclerView.setAdapter(remediesAdapter);
        recyclerView.setHasFixedSize(true);
    }

    /*private void filterList(String text){
         List<remedies>filteredList=new ArrayList<>();
         for(remedies item:remedyList){

         }
         if(filteredList.isEmpty()){
             Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
         }else{
                remedyadapter.setFilteredList(filteredList);
         }
    }*/
    private void searchRemedies(String query) {
        List<remedies> filteredList = new ArrayList<>();
        for (remedies item : remedyList) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No remedies found", Toast.LENGTH_SHORT).show();
        } else {
            remedyadapter remediesAdapter = new remedyadapter(filteredList);
            recyclerView.setAdapter(remediesAdapter);
        }
    }
    private void initData() {
        remedyList=new ArrayList<>();
        remedyList.add(new remedies(R.drawable.acidity,"Acidity","1.teaspoon of baking soda\n2.glass of water (approximately 4 ounces)\n","1.Measure 1/2 teaspoon of baking soda.\n2.Pour 1/2 glass of water into a clean glass.\n3.Add the measured baking soda to the water.\n4. Stir the mixture well until the baking soda is completely dissolved.\n5.Drink the solution slowly.\n6. Wait for a few minutes to allow the mixture to work in neutralizing excess stomach acid.\n7.If needed, you can repeat this remedy after a few hours, but avoid consuming excessive amounts of baking soda."));
        remedyList.add(new remedies(R.drawable.acne,"Acne","1.2 tablespoons of gram flour\n2.1/2 teaspoon of turmeric powder\n3.2-3 tablespoons of water or rose water (adjust for desired consistency)\n 4.Optional: 1 teaspoon of honey or lemon juice (for added benefits)\n","1.In a clean bowl, combine 2 tablespoons of gram flour and 1/2 teaspoon of turmeric powder.\n2.Optional: If using honey or lemon juice, add 1 teaspoon to the mixture. Honey has antibacterial properties, while lemon juice can help lighten acne scars.\n3.Gradually add water or rose water to the mixture, stirring well, until a smooth paste-like consistency is achieved.\n4.Cleanse your face and pat it dry.\n5.Apply the paste to your face, focusing on the areas affected by acne. You can use your fingers or a clean brush for application.\n6.Leave the mask on for about 15-20 minutes or until it dries.\n7.Gently rinse off the mask using warm water, massaging your skin in circular motions.\n8.Pat your face dry and apply a light moisturizer suitable for acne-prone skin."));
        remedyList.add(new remedies(R.drawable.allergy,"Allergy","1.A cup of distilled or boiled water\n2.1/2 teaspoon of salt (non-iodized)\n3.A pinch of baking soda (optional)","1.Boil the water and allow it to cool to a lukewarm temperature. Alternatively, you can use distilled water.\n2.Pour the lukewarm water into a clean container or a neti pot.\n 3.Add 1/2 teaspoon of non-iodized salt to the water. Stir until the salt is dissolved.\n 4.If desired, add a pinch of baking soda to the mixture and stir well. Baking soda can help soothe nasal passages.\n 5.Stand over a sink or tilt your head over a basin.\n 6.Using a neti pot or a clean nasal irrigation bottle, pour the saline solution into one nostril while tilting your head to the side. The solution should flow through the nasal cavity and come out of the other nostril.\n 7.Blow your nose gently to remove any remaining solution or mucus.\n 8.Repeat the process with the other nostril.\n 9.Rinse the irrigation device thoroughly with clean water after each use and allow it to air dry."));
        remedyList.add(new remedies(R.drawable.anxiety,"Anxiety","1.A cup of hot water\n2.A teaspoon of dried chamomile flowers or chamomile tea bag\n3. Honey (optional, for sweetness)","1.Boil water in a kettle or on the stove until it reaches a rolling boil.\n2.Place the dried chamomile flowers or chamomile tea bag into a cup.\n 3.Pour the hot water over the chamomile flowers or tea bag.\n4.Cover the cup and let it steep for about 5 minutes to allow the chamomile to infuse into the water.\n5.If desired, add a small amount of honey for sweetness.\n6.Remove the chamomile flowers or tea bag and stir the mixture.\n 7.Allow the tea to cool slightly before drinking.\n8.Drink the chamomile tea slowly, taking deep breaths and focusing on the soothing warmth and aroma."));
        remedyList.add(new remedies(R.drawable.badbreath, "Bad breath","1.Fresh mint leaves or parsley\n2.Lemon juice (optional)\n3.Water","1.Take a handful of fresh mint leaves or parsley.\n2.Rinse the leaves thoroughly under running water to remove any dirt or debris.\n3.hop the mint leaves or parsley finely to release their natural oils.\n4.Boil a cup of water and remove it from heat.\n5.Place the chopped mint leaves or parsley in a heat-resistant container or mug.\n6.Pour the hot water over the leaves.\n7.Cover the container and let it steep for about 10-15 minutes.\n8.After steeping, strain the mixture to remove the leaves, and allow it to cool down.\n9.If desired, add a teaspoon of lemon juice to the mixture. Lemon juice can help combat bacteria that cause bad breath.\n10.Once the mixture has cooled, use it as a mouthwash.\n11.Take a sip of the homemade mouthwash, swish it around in your mouth for about 30 seconds, and then spit it out.\n12.Repeat this process until you have used up the entire mixture.\n13.Rinse your mouth with plain water afterward to remove any residue."));
        // remedyList.add(new remedies(R.drawable.cough,"cough and sore throat","1.pepper \n2.ginger\n3.Basil Leaves","1.Crush some pepper and take it with honey\n2.Crush ginger and extract the juice and mix with jaggery and consume it\n3.Chew some basil leaves in the morning"));
        remedyList.add(new remedies(R.drawable.cold,"common cold","1.Garlic soup\n2.onion juice\n3.Tulsi leaves","1.Chop few garlic and stir it with hot water\n2.Extract onion juice and consume 1tbsp everyday.\n3. Put some tulsi leaves in a bowl of hot water and take the steam."));
        remedyList.add(new remedies(R.drawable.cough,"cough and sore throat","1.pepper \n2.ginger\n3.Basil Leaves","1.Crush some pepper and take it with honey\n2.Crush ginger and extract the juice and mix with jaggery and consume it\n3.Chew some basil leaves in the morning"));
        remedyList.add(new remedies(R.drawable.fever,"Fever","1.A tablespoon of ginger (freshly grated or sliced)\n2.A cup of water\n3.A teaspoon of honey (optional)","1.Pour one cup of water into a saucepan and bring it to a boil.\n2.Add the grated or sliced ginger to the boiling water.\n3.Reduce the heat to low and let the ginger simmer in the water for about 5 minutes.\n4.Turn off the heat and cover the saucepan. Allow the mixture to steep for an additional 5 minutes.\n5.Strain the liquid to remove the ginger pieces, and pour the ginger tea into a mug.\n6.If desired, add a teaspoon of honey to the tea for added flavor and soothing properties.\n7.Allow the tea to cool down slightly before consuming.\n8.Sip the ginger tea slowly, but do not drink it while it's too hot.\n9.Repeat this remedy as needed to help manage fever symptoms."));
    }


}