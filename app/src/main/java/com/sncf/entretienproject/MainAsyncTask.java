package com.sncf.entretienproject;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author omar_bennouna
 */

public class MainAsyncTask extends AsyncTask<Void, Void, Main> {

    @Override
    protected Main doInBackground(Void... voids) {
        Main result = new Main();
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("https://api.github.com/search/repositories?q=stars:%3E1&sort=stars&order=desc");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(urlConnection.getInputStream());
            Gson gson = new Gson();
//            Type listType = new TypeToken<ArrayList<Main>>(){}.getType();
            result = gson.fromJson(in, Main.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return result;
    }
}
