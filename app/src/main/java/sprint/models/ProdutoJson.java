package sprint.models;

public class ProdutoJson {
    private int id; //id
    private String title; //nome
    private double price; //preco
    private String description; //descricao
    private String category; //categoria
    
    public ProdutoJson(int id, String title, double price, String description, String category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}