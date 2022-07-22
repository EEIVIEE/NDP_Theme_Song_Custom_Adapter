package sg.edu.rp.c346.id21021397.nationaldayparadethemesongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayRecords extends AppCompatActivity {

    Button btnStar;
    ArrayList<Song> alSong;
    ListView lvSong;
    //ArrayAdapter aaSong;
    CustomAdapter caSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_records);

        btnStar = findViewById(R.id.btnStar);
        lvSong = findViewById(R.id.lvSong);
        alSong = new ArrayList<Song>();
        //aaSong = new ArrayAdapter<Song>(this,
                //android.R.layout.simple_list_item_1, alSong);
        caSong = new CustomAdapter(this, R.layout.row, alSong);
        lvSong.setAdapter(caSong);

        DBHelper dbh = new DBHelper(DisplayRecords.this);
        alSong.clear();
        alSong.addAll(dbh.getAllSongs());
        caSong.notifyDataSetChanged();

        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(DisplayRecords.this);
                alSong.clear();
                // al.addAll(dbh.getAllNotes());
                int filterText = 5;
                alSong.addAll(dbh.getStarSongs(filterText));

                caSong.notifyDataSetChanged();
            }
        });

        lvSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = alSong.get(position);
                Intent i = new Intent(DisplayRecords.this,
                        EditActivity.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(DisplayRecords.this);
        alSong.clear();
        alSong.addAll(dbh.getAllSongs());
        caSong.notifyDataSetChanged();
    }
}
