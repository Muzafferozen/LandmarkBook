package com.muzafferozen.landmarkbook;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.muzafferozen.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



            landmarkArrayList = new ArrayList<>();

        Landmark pisa = new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark eiffel = new Landmark("Eiffel","France",R.drawable.eiffeltower);
        Landmark colosseum = new Landmark("Colosseum","Italy",R.drawable.colosseum);
        Landmark londonBridge= new Landmark("London bridge","UK",R.drawable.londonbridge);
        Landmark aspendos = new Landmark("aspendos","Turkey",R.drawable.aspendos);
        Landmark efesantik= new Landmark("efesantik","turkey",R.drawable.efesantik);
        Landmark hasankeyf = new Landmark("hasankeyf","Turkey",R.drawable.hasankeyf);
        Landmark myra = new Landmark("myra","Turkey",R.drawable.myra);
        Landmark xanthosletton = new Landmark("xanthosletton0","Turkey",R.drawable.xanthosletton);


        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(londonBridge);
        landmarkArrayList.add(aspendos);
        landmarkArrayList.add(efesantik);
        landmarkArrayList.add(hasankeyf);
        landmarkArrayList.add(myra);
        landmarkArrayList.add(xanthosletton);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);



       /* ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,

                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())

        );
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               // Toast.makeText(MainActivity.this,landmarkArrayList.get(i).name,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(i));
                startActivity(intent);

            }
        });

*/


    }
}