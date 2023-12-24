package model;

public class Tour_category {
    private int id;
    private String category_name;

    public Tour_category(int id, String category_name) {
        this.id = id;
        this.category_name = category_name;
    }

    public Tour_category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
