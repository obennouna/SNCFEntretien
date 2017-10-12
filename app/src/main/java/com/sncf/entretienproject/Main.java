package com.sncf.entretienproject;

import java.util.ArrayList;

/**
 * @author omar_bennouna
 */

public class Main {
    public int total_count;
    public ArrayList<MainItems> items;

    static class MainItems {
        public String name;
        public String html_url;
        public String description;
        public Owner owner;
    }

    static class Owner {
        public String avatar_url;
    }
}
