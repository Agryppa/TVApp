package com.example.herud.tvapp;


import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MainFragment extends BrowseFragment {

    private ArrayObjectAdapter mRowsAdapter;

    private ArrayList<Picture>list;
    private void fill()
    {
        list=new ArrayList<>();
        list.add(new Picture(R.drawable.aooexwx_700b,"tauben"));
        list.add(new Picture(R.drawable.aapdwwe_460s_v1,"my shelf"));
        list.add(new Picture(R.drawable.pretty_sure_you_mean_that_they_d_rather_commit_sudoku__6872aafdcd46cac7969ae6f8e7ad597f,"sudoku"));
        list.add(new Picture(R.drawable.hound,"hound"));
        list.add(new Picture(R.drawable.ambydyx_460s,"caesar"));


    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setTitle("An android tv app");

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);


        setBrandColor(getResources().getColor(R.color.lb_basic_card_bg_color));
        setSearchAffordanceColor(getResources().getColor(R.color.lb_basic_card_bg_color));
        setHeaderPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object o) {
                return new MyHeaderPresenter();
            }
        });
        loadRows();
    }


    private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        fill();

        CardPresenter cardPresenter = new CardPresenter();

        for(int i=0; i<list.size(); i++) {
            MyHeader cardPresenterHeader = new MyHeader(i, "",list.get(i).getId());
            ArrayObjectAdapter aObjAd=new ArrayObjectAdapter((cardPresenter));


            aObjAd.add(list.get(i));
            mRowsAdapter.add(new ListRow(cardPresenterHeader, aObjAd));




        }

        setAdapter(mRowsAdapter);
    }



}