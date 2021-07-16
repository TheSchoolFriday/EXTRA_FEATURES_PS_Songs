package sg.edu.rp.c346.id20046797.ps_songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class thirdActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear, etId;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    RadioGroup rg;
    Button btnUpdate, btnDelete, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        rg = findViewById(R.id.rbGroup2);

        etTitle = findViewById(R.id.etSongTitle2);
        etSinger = findViewById(R.id.etSingersName2);
        etYear = findViewById(R.id.etSongYear2);
        etId = findViewById(R.id.etSongID2);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        rb1 = findViewById(R.id.rbStar1);
        rb2 = findViewById(R.id.rbStar2);
        rb3 = findViewById(R.id.rbStar3);
        rb4 = findViewById(R.id.rbStar4);
        rb5 = findViewById(R.id.rbStar5);

        Intent i = getIntent();
        final Song obtainedSong = (Song) i.getSerializableExtra("song");

        etId.setText(String.valueOf(obtainedSong.get_id()));
        etTitle.setText(obtainedSong.getTitle());
        etSinger.setText(obtainedSong.getSingers());
        etYear.setText(String.valueOf(obtainedSong.getYear()));

        int amountOfStars = obtainedSong.getStars();

        switch (amountOfStars) {
            case 1:
                rb1.setChecked(true);
                break;
            case 2:
                rb2.setChecked(true);
                break;
            case 3:
                rb3.setChecked(true);
                break;
            case 4:
                rb4.setChecked(true);
                break;
            case 5:
                rb5.setChecked(true);
                break;
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(thirdActivity.this);
                obtainedSong.setTitle(etTitle.getText().toString());
                obtainedSong.setSingers(etSinger.getText().toString());
                obtainedSong.setYear(Integer.parseInt(etYear.getText().toString()));

                int selectedID = rg.getCheckedRadioButtonId();
                int starRating = 0;

                if (selectedID == R.id.rbStar1) {
                    starRating = 1;
                } else if (selectedID == R.id.rbStar2) {
                    starRating = 2;
                } else if (selectedID == R.id.rbStar3) {
                    starRating = 3;
                } else if (selectedID == R.id.rbStar4) {
                    starRating = 4;
                } else if (selectedID == R.id.rbStar5) {
                    starRating = 5;
                }

                obtainedSong.setStars(starRating);
                int number = dbh.updateSong(obtainedSong);
                btnCancel.performClick();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(thirdActivity.this);
                int number = dbh.deleteSong(obtainedSong.get_id());
                Toast.makeText(thirdActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                btnCancel.performClick();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(thirdActivity.this, secondActivity.class);
                startActivity(i);
            }
        });
    }
}