package iam.deprest.oefnotedroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import iam.deprest.oefnotedroid.model.Note;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDate;
    private EditText tvTitle;
    private EditText tvNote;
    private Note gekozenNote;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDate = findViewById(R.id.tv_date);
        tvTitle = findViewById(R.id.et_title);
        tvNote = findViewById(R.id.et_note);

        gekozenNote = (Note) getIntent().getSerializableExtra("note");
        tvTitle.setText(gekozenNote.getTitle());
    }
}
