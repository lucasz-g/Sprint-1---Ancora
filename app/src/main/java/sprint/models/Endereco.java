package sprint.models;

public class Endereco {
    private static int id = 0;
    private int idEndereco;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, String cidade, String estado, String cep) {
        idEndereco = ++id;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    //Getters e Setters
    public String getEnderecoCompleto(){
        return (rua + ", " + cidade + ", " + estado + " - " + cep);
    }


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
