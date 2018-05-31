package main.java.views;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItemView {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleFloatProperty price;

    public ItemView(int id, String name, float price) {
        this.id.set(id);
        this.name.set(name);
        this.price.set(price);
    }

    public ItemView() {
        this(0, "", 0);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public float getPrice() {
        return price.get();
    }

    public void setPrice(float price) {
        this.price.set(price);
    }
}
