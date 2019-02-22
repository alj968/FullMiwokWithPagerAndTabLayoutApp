package com.honorsmobileapps.amandajones.fullmiwokwithpagerandtablayoutapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordViewHolder> {
    private List<Word> mWords;
    private int mColorResourceId;

    public WordAdapter(List<Word> words, int colorResourceId) {
        mWords = words;
        mColorResourceId = colorResourceId;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.word_list_item, parent, false);
        return new WordViewHolder(view, mColorResourceId);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Word word = mWords.get(position);
        holder.bindWord(word);
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

}


