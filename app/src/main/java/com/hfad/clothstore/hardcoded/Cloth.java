package com.hfad.clothstore.hardcoded;

import com.hfad.clothstore.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Cloth implements Serializable {
    private String name;
    private int imageResourceId;
    private String gender;
    private String type;
    private Double price;
    public static ArrayList<Cloth> cartItems = new ArrayList<>();
    public static ArrayList<Cloth> favoritesItems = new ArrayList<>();
    public static final Cloth[] clothes = {
            new Cloth("T shirt", R.drawable.t_shirt, "shirt", "male", 32),
            new Cloth("Top", R.drawable.top_woman, "top",  "female", 23.50),
            new Cloth("T-shirt", R.drawable.jeans, "shirt",  "female", 23),
            new Cloth("Top", R.drawable.shirt, "shirt",  "male", 65),
            new Cloth("Dress", R.drawable.jeans, "jeans", "female", 122),
            new Cloth("Shirt", R.drawable.shirt, "shirt", "children", 16),
            new Cloth("Jeans", R.drawable.jeans, "jeans","children", 17),
            new Cloth("Jacket", R.drawable.jacket, "jacket", "female", 96),
            new Cloth("Shirt", R.drawable.shirt, "shirt", "male", 87)
    };

    private Cloth(String name, int imageResourceId, String type, String gender, double price) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.type = type;
        this.gender = gender;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }
}
