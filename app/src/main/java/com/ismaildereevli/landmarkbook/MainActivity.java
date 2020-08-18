package com.ismaildereevli.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);

        final ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Brandenburg Gate");
        landmarkNames.add("Colosseo");
        landmarkNames.add("Eiffel Tower ");
        landmarkNames.add("Hagia Sophia");
        landmarkNames.add("La Sagrada Familia ");
        landmarkNames.add("Lighthouse of Alexandria");
        landmarkNames.add("London Bridge");
        landmarkNames.add("Tokyo Tower");

        final ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Germany");
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Turkey");
        countryNames.add("Spain");
        countryNames.add("Egypt");
        countryNames.add("United Kingdom");
        countryNames.add("Japan");

        Bitmap brandenburg = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.brandenburg);
        Bitmap colosseo = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colo);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eiffel);
        Bitmap hagia = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.hagiasophiajpg);
        Bitmap sagrada = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.lasagrada);
        Bitmap alexandria = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.lighthouseofalexandria);
        Bitmap london = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.londonbridge);
        Bitmap tokyo = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.tokyotower);


        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(brandenburg);
        landmarkImages.add(colosseo);
        landmarkImages.add(eiffel);
        landmarkImages.add(hagia);
        landmarkImages.add(sagrada);
        landmarkImages.add(alexandria);
        landmarkImages.add(london);
        landmarkImages.add(tokyo);


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("landmarkName", landmarkNames.get(i));
                intent.putExtra("countryName", countryNames.get(i));
                Singleton singleton = Singleton.getInstance();
                singleton.setSelectedImage(landmarkImages.get(i));


                startActivity(intent);


            }
        });
    }
}