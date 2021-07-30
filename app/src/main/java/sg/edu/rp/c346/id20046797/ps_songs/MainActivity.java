package sg.edu.rp.c346.id20046797.ps_songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etSongTitle, etSingersName, etSongYear;
    RadioGroup starGroup;
    Button btnInsert, btnShowList;
    RatingBar rbStar;

    ArrayList<Song> SongList = new ArrayList<Song>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSongTitle = findViewById(R.id.etSongTitle);
        etSingersName = findViewById(R.id.etSingersName);
        etSongYear = findViewById(R.id.etSongYear);

//        starGroup = findViewById(R.id.rbGroup);
        rbStar = findViewById(R.id.ratingBar);

        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String songTitle = etSongTitle.getText().toString();
                String singersName = etSingersName.getText().toString();
                int songYear = Integer.parseInt(etSongYear.getText().toString());
                int starRating = Math.round(rbStar.getRating());
                Toast.makeText(MainActivity.this, String.valueOf(starRating), Toast.LENGTH_SHORT).show();

//                int selectedID = starGroup.getCheckedRadioButtonId();
//
//                if (selectedID == R.id.rbStar1) {
//                    starRating = 1;
//                } else if (selectedID == R.id.rbStar2) {
//                    starRating = 2;
//                } else if (selectedID == R.id.rbStar3) {
//                    starRating = 3;
//                } else if (selectedID == R.id.rbStar4) {
//                    starRating = 4;
//                } else if (selectedID == R.id.rbStar5) {
//                    starRating = 5;
//                }

                DBHelper DBH = new DBHelper(MainActivity.this);
                DBH.insertSongs(songTitle, singersName, songYear, starRating);
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, secondActivity.class);
                startActivity(i);
            }
        });
    }
}