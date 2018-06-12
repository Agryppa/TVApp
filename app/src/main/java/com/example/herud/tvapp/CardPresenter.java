package com.example.herud.tvapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


public class CardPresenter extends Presenter {

    private static final String TAG = CardPresenter.class.getSimpleName();

    private static Context mContext;
    private static int CARD_WIDTH = 350;
    private static int CARD_HEIGHT = 500;

    static class ViewHolder extends Presenter.ViewHolder {
        private final Drawable mDefaultCardImage;
        private Picture picture;
        private ImageCardView mCardView;


        public ViewHolder(View view) {
            super(view);
            mCardView = (ImageCardView) view;
            mDefaultCardImage = mContext.getResources().getDrawable(R.drawable.aooexwx_700b);
        }

        public void setPicture(Picture m) {
            picture = m;
        }

        public Picture getPicture() {
            return picture;
        }

        public ImageCardView getCardView() {
            return mCardView;
        }

        public Drawable getDefaultCardImage() {
            return mDefaultCardImage;
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        mContext = parent.getContext();

        ImageCardView cardView = new ImageCardView(mContext);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        cardView.setBackgroundColor(mContext.getResources().getColor(R.color.lb_grey));
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        Picture picture = (Picture) item;
        ((ViewHolder) viewHolder).setPicture(picture);


        ((ViewHolder) viewHolder).mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
        ((ViewHolder) viewHolder).mCardView.setMainImage(mContext.getResources().getDrawable(picture.getId()));
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }

    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder viewHolder) {
        // TO DO
    }

}