package iam.deprest.oefnotedroid.note_utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import iam.deprest.oefnotedroid.R;
import iam.deprest.oefnotedroid.model.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvNote, tvTitle, tvDate;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvNote = itemView.findViewById(R.id.tv_note);
        }
    }

    private ArrayList<Note> notes;

    public NoteAdapter(ArrayList<Note> notes){
        this.notes = notes;
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
        noteViewHolder.tvTitle.setText(noteInRij.getTitle());
        noteViewHolder.tvDate.setText(noteInRij.getDate().toString());
        noteViewHolder.tvNote.setText(noteInRij.getNote());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}