package iam.deprest.oefnotedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import iam.deprest.oefnotedroid.model.Note;
import iam.deprest.oefnotedroid.model.NoteDAO;
import iam.deprest.oefnotedroid.note_utilities.NoteAdapter;
import iam.deprest.oefnotedroid.note_utilities.RecyclerTouchListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvNotes;
    private NoteAdapter adapter;
    private Note clickedNote;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mi_btn_delete){
            //start action
            NoteDAO.getInstance().getNoteList().remove(clickedNote);
        }

        if (item.getItemId() == R.id.mi_add_note){
            //start nav
            Intent intent = new Intent(this, NewActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link met recycler:
        rvNotes = findViewById(R.id.rv_notesList);
        //hoe recycler opvullen? => adapter
        adapter = new NoteAdapter(NoteDAO.getInstance().getNoteList());
        rvNotes.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvNotes.setLayoutManager(layoutManager);
    }
}
