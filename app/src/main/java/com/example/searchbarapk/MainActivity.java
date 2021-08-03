package com.example.searchbarapk;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView myListView1;
    String[]cities= {"Agra","Delhi","Mumbai","Chennai","Kolkata","Gujrat","Banglore","lucknow","Uttar Pradesh","MP","Tamilnadu","Dholpur","Patna","CP","Bangal","RamPur","Jonpur","Sikkim","Himachal Pradesh","Arunachal Pradesh","Bihar"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView1=findViewById(R.id.myListView);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cities);
        myListView1.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type Here To Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}