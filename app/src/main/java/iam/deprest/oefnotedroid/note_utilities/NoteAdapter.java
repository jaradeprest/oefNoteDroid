package iam.deprest.oefnotedroid.note_utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import iam.deprest.oefnotedroid.R;
import iam.deprest.oefnotedroid.model.Converter;
import iam.deprest.oefnotedroid.model.Note;
import iam.deprest.oefnotedroid.model.NoteDatabase;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> notes;
    private Context context;

    public NoteAdapter(List<Note> noteList, Context context) {
        this.notes = noteList;
        this.context = context;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvNote, tvTitle, tvDate;
        public Button btnDelete;

        private View.OnClickListener deleteListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positition = getAdapterPosition();
                Note toDelete = notes.get(positition);
                NoteDatabase.getInstance(context).getNoteDAO().deleteNote(toDelete);
                notes.remove(toDelete);
                notifyDataSetChanged();
            }
        };


        public NoteViewHolder(View view){
            super(view);
            view.setTag(this);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDate = view.findViewById(R.id.tv_date);
            tvNote = view.findViewById(R.id.tv_note);
            btnDelete = view.findViewById(R.id.btn_delete);
            btnDelete.setOnClickListener(deleteListener);
        }
    }

    @NonNull
    @Override
    //hoe ziet een rij eruit?
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
            // == lijst waar alle rijen in zullen komen
        View rijView = LayoutInflater.from(context).inflate(R.layout.note_card, viewGroup, false);
            // == binnen de context een layoutfile omzetten naar scherm
        return new NoteViewHolder(rijView);
            // == nieuwe viewHolder, op basis van getekende layout
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int i) {
        // i = positionInList
        Note noteInRij = notes.get(i);
        String dateAlsString = Converter.fromDate(noteInRij.getPublishDate());
        noteViewHolder.tvTitle.setText(noteInRij.getTitle());
        noteViewHolder.tvDate.setText(dateAlsString);
        noteViewHolder.tvNote.setText(noteInRij.getNote());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
