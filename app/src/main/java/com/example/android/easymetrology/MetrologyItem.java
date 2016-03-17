package com.example.android.easymetrology;

import java.util.ArrayList;

/**
 * Created by denisvieira on 15/03/16.
 */
public class MetrologyItem {
    public Integer id;
    public String title;
    public String description;

    public MetrologyItem(Integer id, String title, String description){
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<MetrologyItem> getConverters() {
        ArrayList<MetrologyItem> converters = new ArrayList<MetrologyItem>();
        converters.add(new MetrologyItem(1,"Milimetro | Polegada Milesimal", "Converta seu valor em Milimetro para Polegada Milesimal"));
        converters.add(new MetrologyItem(2,"Polegada Milesimal | Milimetro", "Converta seu valor em Polegada Milesimal para Milimetro"));
        converters.add(new MetrologyItem(3,"Polegada Fracionária | Milimetro", "Converta seu valor em Polegada Fracionária para Milimetro"));
        converters.add(new MetrologyItem(4,"Polegada Fracionária | Polegada Milesimal ", "Converta seu valor em Polegada Fracionária para Polegada Milesimal "));
        converters.add(new MetrologyItem(5,"Milimetro | Polegada Fracionária", "Converta seu valor em Milimetro para Polegada Fracionária "));
        return converters;
    }
    public static ArrayList<MetrologyItem> getCalculators() {
        ArrayList<MetrologyItem> calculators = new ArrayList<MetrologyItem>();
        calculators.add(new MetrologyItem(1, "Aproximação (Sensibilidade)", "Calcular a aproximação (também chamada sensibilidade) dos paquímetros"));
        return calculators;
    }
}
