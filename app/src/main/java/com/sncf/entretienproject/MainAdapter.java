package com.sncf.entretienproject;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * @author omar_bennouna
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    
    private ArrayList<MainItem> mData;
    
    private boolean mFirstItemCreated;
    
    private ValueAnimator mAnimation;
    
    MainAdapter() {
        mData = new ArrayList<>();
        
        for (int i = 0; i < 100; i++) {
            mData.add(new MainItem(String.valueOf(i)));
        }
    }
    
    @Override
    public MainAdapter.MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (!mFirstItemCreated) {
            mFirstItemCreated = true;
            
            mAnimation = ValueAnimator.ofInt(0, 100);
            mAnimation.setDuration(5_000L);
            mAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            mAnimation.start();
        }
        
        return new MainAdapter.MainHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
    }
    
    @Override
    public void onBindViewHolder(MainAdapter.MainHolder holder, int position) {
        holder.bind(mData.get(position).getId());
        
        mAnimation.addUpdateListener(holder);
    }
    
    @Override
    public void onViewRecycled(MainHolder holder) {
        super.onViewRecycled(holder);
        
        mAnimation.removeUpdateListener(holder);
    }
    
    @Override
    public int getItemCount() {
        return mData.size();
    }
    
    class MainHolder extends RecyclerView.ViewHolder implements AnimatorUpdateListener {
        
        private TextView title;
        private TextView description;
        
        MainHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.main_title);
            description = itemView.findViewById(R.id.main_description);
        }
        
        void bind(String id) {
            description.setText(id);
        }
    
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            title.setText(String.valueOf((int) animation.getAnimatedValue()));
        }
    }
}
