package com.example.android.easymetrology;

import java.util.ArrayList;

/**
 * Created by denisvieira on 15/03/16.
 */
public class ConverterItem {
    public String title;
    public String description;

    public ConverterItem(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<ConverterItem> getConverters() {
        ArrayList<ConverterItem> converters = new ArrayList<ConverterItem>();
        converters.add(new ConverterItem("Milimetro | Polegada Milesimal", "Converta seu valor em Milimetro para Polegada Milesimal"));
        converters.add(new ConverterItem("Polegada Milesimal | Milimetro", "Converta seu valor em Polegada Milesimal para Milimetro"));
        return converters;
    }
}
