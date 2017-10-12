package com.sncf.entretienproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        final TextView size = (TextView) findViewById(R.id.size_result);
        final MainAdapter adapter = new MainAdapter(this);
        new MainAsyncTask() {
            @Override
            protected void onPostExecute(final Main data) {
                size.setText(data.items.size() + " résultats");
                adapter.setData(data.items);
            }
        }.execute();
        recyclerView.setAdapter(adapter);
    }
}
