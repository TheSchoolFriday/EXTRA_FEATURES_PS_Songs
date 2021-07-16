package sg.edu.rp.c346.id20046797.ps_songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class secondActivity extends AppCompatActivity {

    ListView lv;
    Button btnShowStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        lv = findViewById(R.id.lv);
        btnShowStars = findViewById(R.id.btnAll5Stars);

        DBHelper dbh = new DBHelper(this);

        ArrayList<Song> al = new ArrayList<>(dbh.getAllSongs());
        ArrayAdapter<Song> aa = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(secondActivity.this, thirdActivity.class);
                i.putExtra("song", al.get(position));
                startActivity(i);
            }
        });

        btnShowStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper DBH = new DBHelper(secondActivity.this);

                al.clear();
                al.addAll(DBH.getSongsByStars(5));
                aa.notifyDataSetChanged();
            }
        });
    }
}