package com.example.homeremedy;

/*public class Disease {
    private int imageResId;
    private String name;

    public Disease(String imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }
}*/

import java.util.ArrayList;

public class Disease {
    private String imageResId;
    private String name;

    public Disease(String imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public Disease(int allergy, String allergy1) {
    }

    public String getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public static Disease get(ArrayList<Disease> diseases, int position) {
        if (position >= 0 && position < diseases.size()) {
            return diseases.get(position);
        }
        return null;
    }
}


