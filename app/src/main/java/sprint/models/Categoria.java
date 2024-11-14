package sprint.models;

public class Categoria {
    private static int id = 0;
    private int idCategoria;
    private String nomeCategoria;

    // Getters e Setters
    public Categoria(String nomeCategoria){
        this.nomeCategoria = nomeCategoria;
        idCategoria =++ id;
    }
    
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Categoria.id = id;
    }

}
