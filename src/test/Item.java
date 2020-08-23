package test;

public class Item {

    String name;
    String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Item(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
