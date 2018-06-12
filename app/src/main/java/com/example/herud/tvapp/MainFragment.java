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
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MainFragment extends BrowseFragment {

    private ArrayObjectAdapter mRowsAdapter;
    private static final int GRID_ITEM_WIDTH = 350;
    private static final int GRID_ITEM_HEIGHT = 500;
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

        setupUIElements();

        loadRows();
    }

    private void setupUIElements() {

        setTitle("An android tv app");

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);


        setBrandColor(getResources().getColor(R.color.lb_basic_card_bg_color));
        setSearchAffordanceColor(getResources().getColor(R.color.lb_basic_card_bg_color));
    }

    private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        fill();

        CardPresenter cardPresenter = new CardPresenter();

        for(int i=0; i<list.size(); i++) {
            HeaderItem cardPresenterHeader = new HeaderItem(i, list.get(i).getName());
            ArrayObjectAdapter aObjAd=new ArrayObjectAdapter((cardPresenter));


            aObjAd.add(list.get(i));

            mRowsAdapter.add(new ListRow(cardPresenterHeader, aObjAd));




        }

        setAdapter(mRowsAdapter);
    }

    private class GridItemPresenter extends Presenter {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            TextView view = new TextView(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(getResources().getColor(R.color.lb_default_search_color));
            view.setTextColor(Color.WHITE);
            view.setGravity(Gravity.CENTER);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            ((TextView) viewHolder.view).setText((String) item);
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }

}