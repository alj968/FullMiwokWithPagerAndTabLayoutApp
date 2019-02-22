package com.honorsmobileapps.amandajones.fullmiwokwithpagerandtablayoutapp;

import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mDefaultWordTextView;
    private TextView mMiwokWordTextView;
    private ImageView mWordImageView;
    private Word mWord;

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public WordViewHolder(View itemView, int colorResourceId) {
        super(itemView);
        itemView.setOnClickListener(this);
        mDefaultWordTextView = (TextView) itemView.findViewById(R.id.textViewDefaultWord);
        mMiwokWordTextView = (TextView) itemView.findViewById(R.id.textViewMiwokWord);
        mWordImageView = (ImageView) itemView.findViewById(R.id.imageViewWord);
        LinearLayout textContainer = (LinearLayout) itemView.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(itemView.getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);
    }

    public void bindWord(Word word) {
        mWord = word;
        mDefaultWordTextView.setText(mWord.getDefaultTranslation());
        mMiwokWordTextView.setText(mWord.getMiwokTranslation());
        if(word.hasImage()) {
            mWordImageView.setImageResource(mWord.getImageResourceId());
        }
    }


    @Override
    public void onClick(View v) {
        releaseMediaPlayer();
        mMediaPlayer = MediaPlayer.create(v.getContext(), mWord.getAudioResourceId());
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
    }

    private void releaseMediaPlayer() {
        if(mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}

