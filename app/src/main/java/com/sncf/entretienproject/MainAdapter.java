package com.sncf.entretienproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * @author omar_bennouna
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private AppCompatActivity activity;
    private ArrayList<Main.MainItems> mData;

    MainAdapter(AppCompatActivity context) {
        activity = context;
        mData = new ArrayList<>();
    }

    public void setData(ArrayList<Main.MainItems> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public MainAdapter.MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainAdapter.MainHolder(LayoutInflater.from(activity).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(MainAdapter.MainHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MainHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Main.MainItems data;
        private TextView title;
        private TextView description;
        private ImageView img;

        MainHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.main_title);
            description = (TextView) itemView.findViewById(R.id.main_description);
            img = (ImageView) itemView.findViewById(R.id.main_img);
            itemView.setOnClickListener(this);
        }

        public void setData(Main.MainItems data) {
            this.data = data;
            title.setText(data.name);
            description.setText(data.description);
            Picasso.with(activity)
                    .load(data.owner.avatar_url)
                    .fit()
                    .into(img);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, MainWebViewActivity.class);
            intent.putExtra("URL", data.html_url);
            activity.startActivity(intent);
        }
    }
}
