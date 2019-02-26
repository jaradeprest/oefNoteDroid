package iam.deprest.oefnotedroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import iam.deprest.oefnotedroid.model.Note;
import iam.deprest.oefnotedroid.model.NoteDAO;
import iam.deprest.oefnotedroid.model.NoteDatabase;

public class NewActivity extends AppCompatActivity {

    private EditText etTitle, etNote;
    private Button btnSave;
    private TextView tvDate;

    private View.OnClickListener saveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String title = etTitle.getText().toString();
            String note = etNote.getText().toString();

            Note newNote = new Note(title, note, new Date());
            NoteDatabase.getInstance(getApplicationContext()).getNoteDAO().insertNote(newNote);

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        etTitle = findViewById(R.id.et_title);
        etNote = findViewById(R.id.et_note);
        tvDate = findViewById(R.id.tv_date);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(saveListener);
    }
}
