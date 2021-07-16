package sg.edu.rp.c346.id20046797.ps_songs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etSongTitle, etSingersName, etSongYear;
    RadioButton star1, star2, star3, star4, star5;
    RadioGroup starGroup;
    Button btnInsert, btnShowList;
    ListView lvTest;

    ArrayList<Song> SongList = new ArrayList<Song>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSongTitle = findViewById(R.id.etSongTitle);
        etSingersName = findViewById(R.id.etSingersName);
        etSongYear = findViewById(R.id.etSongYear);

        star1 = findViewById(R.id.rbStar1);
        star2 = findViewById(R.id.rbStar2);
        star3 = findViewById(R.id.rbStar3);
        star4 = findViewById(R.id.rbStar4);
        star5 = findViewById(R.id.rbStar5);
        starGroup = findViewById(R.id.rbGroup);

        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);

        ArrayAdapter<Song> aa = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, SongList);
        lvTest = findViewById(R.id.lvTest);
        lvTest.setAdapter(aa);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String songTitle = etSongTitle.getText().toString();
                String singersName = etSingersName.getText().toString();
                int songYear = Integer.parseInt(etSongYear.getText().toString());
                int starRating = 0;
                int selectedID = starGroup.getCheckedRadioButtonId();

                if (selectedID == R.id.rbStar1) {
                    
                } else if (selectedID == R.id.rbStar2) {

                } else if (selectedID == R.id.rbStar3) {

                } else if (selectedID == R.id.rbStar4) {

                } else if (selectedID == R.id.rbStar5) {

                }

                DBHelper DBH = new DBHelper(MainActivity.this);
                long inserted_id = DBH.insertSongs(songTitle, singersName, songYear, starRating);

                if (inserted_id != 1) {
                    SongList.clear();
                    SongList.addAll(DBH.getAllSongs());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}