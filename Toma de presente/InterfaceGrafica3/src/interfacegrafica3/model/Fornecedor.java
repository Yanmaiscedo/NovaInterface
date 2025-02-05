package interfacegrafica3.model;

public class Fornecedor extends PessoaJuridica {
    private String categoria;
    private String uf;

    public Fornecedor(String categoria, String uf, String cnpj, String inscricaoEstadual, 
                      String nomeFantasia, String nome, String email, String endereco, 
                      String telefone, int id) {
        super(cnpj, inscricaoEstadual, nomeFantasia, nome, email, endereco, telefone, id);
        this.categoria = categoria;
        this.uf = uf;
    }

    public Fornecedor() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}