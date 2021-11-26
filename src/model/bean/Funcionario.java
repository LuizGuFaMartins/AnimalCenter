package model.bean;

public class Funcionario {
    private int id_func;
    private String nome_func;
    private String cpf_func;
    private String cargo_func;
    private String senha_func;
    private int id_adm;

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public String getCpf_func() {
        return cpf_func;
    }

    public void setCpf_func(String cpf_func) {
        this.cpf_func = cpf_func;
    }

    public String getCargo_func() {
        return cargo_func;
    }

    public void setCargo_func(String cargo_func) {
        this.cargo_func = cargo_func;
    }

    public String getSenha_func() {
        return senha_func;
    }

    public void setSenha_func(String senha_func) {
        this.senha_func = senha_func;
    }

    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }
    
    
}
