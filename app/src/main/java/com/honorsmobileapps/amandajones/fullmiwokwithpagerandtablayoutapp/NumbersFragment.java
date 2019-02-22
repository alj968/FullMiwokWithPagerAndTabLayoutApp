package com.honorsmobileapps.amandajones.fullmiwokwithpagerandtablayoutapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class NumbersFragment extends Fragment {

    private RecyclerView mNumbersRecyclerView;
    private WordAdapter mNumbersAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_numbers, container, false);

        mNumbersRecyclerView = (RecyclerView) rootView.findViewById(R.id.numbersRecyclerView);
        mNumbersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Word> numbers = new ArrayList<>();
        numbers.add(new Word("2","otiiko",R.drawable.number_two,R.raw.number_two));
        numbers.add(new Word("3","tolookosu",R.drawable.number_three,R.raw.number_three));
        numbers.add(new Word("4","oyyisa",R.drawable.number_four,R.raw.number_four));
        numbers.add(new Word("5","massokka",R.drawable.number_five,R.raw.number_five));
        numbers.add(new Word("6","temmokka",R.drawable.number_six,R.raw.number_six));
        numbers.add(new Word("7","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new Word("8","kawinta",R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new Word("9","wo’e",R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new Word("10","na’aacha",R.drawable.number_ten,R.raw.number_ten));

        mNumbersAdapter = new WordAdapter(numbers,R.color.category_numbers);
        mNumbersRecyclerView.setAdapter(mNumbersAdapter);

        return rootView;
    }

}