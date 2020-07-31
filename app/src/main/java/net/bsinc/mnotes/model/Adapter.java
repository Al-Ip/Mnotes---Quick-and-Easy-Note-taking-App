package net.bsinc.mnotes.model;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import net.bsinc.mnotes.note.NoteDetails;
import net.bsinc.mnotes.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> titles;
    List<String> content;

    public Adapter(List<String> title, List<String> content){
        this.titles = title;
        this.content = content;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, final int position) {
        holder.noteTitle.setText(titles.get(position));
        holder.noteContent.setText(content.get(position));
        // integer variable stores the random color so it can display it on contents background
        final int colorCode = getRandomColor();
        holder.mCardView.setCardBackgroundColor(holder.view.getResources().getColor(colorCode, null));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NoteDetails.class);
                i.putExtra("title", titles.get(position));
                i.putExtra("content", content.get(position));
                i.putExtra("colorCode", colorCode);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView noteTitle, noteContent;
        View view;
        CardView mCardView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            noteTitle = itemView.findViewById(R.id.titles);
            noteContent = itemView.findViewById(R.id.content);
            mCardView = itemView.findViewById(R.id.noteCard);
            view = itemView;
        }
    }

    //Adding the list of colors from the colors resource file
    private int getRandomColor(){
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.silverPink);
        colorCode.add(R.color.canary);
        colorCode.add(R.color.grannySmithApple);
        colorCode.add(R.color.fireOpal);
        colorCode.add(R.color.beige);
        colorCode.add(R.color.babyPink);
        colorCode.add(R.color.lightStaleGray);
        colorCode.add(R.color.lightPink);
        colorCode.add(R.color.maximumPurple);
        colorCode.add(R.color.azureWebColor);
        colorCode.add(R.color.maroon);
        colorCode.add(R.color.oldRose);
        colorCode.add(R.color.maximumBluePurple);
        colorCode.add(R.color.uranianBlue);
        colorCode.add(R.color.champagnePink);
        colorCode.add(R.color.magicMint);
        colorCode.add(R.color.purpureus);
        colorCode.add(R.color.darkSalmon);
        colorCode.add(R.color.teaGreen);
        colorCode.add(R.color.almond);
        colorCode.add(R.color.deepChampagne);
        colorCode.add(R.color.opal);
        colorCode.add(R.color.lighCyan);
        colorCode.add(R.color.lavendarFloral);
        colorCode.add(R.color.wisteria);

        Random randomColor = new Random();
        int number = randomColor.nextInt(colorCode.size());
        return colorCode.get(number);
    }
}
