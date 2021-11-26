package model.bean;

import java.util.Date;

public class Animal {
    private int id_ani;
    private String nome_ani;
    private String raca_ani;
    private String porte_ani;
    private Date dataNasc_ani;
    private String idade_ani;
    private String Cliente_cpf;

    public int getId_ani() {
        return id_ani;
    }

    public void setId_ani(int id_ani) {
        this.id_ani = id_ani;
    }

    public String getNome_ani() {
        return nome_ani;
    }

    public void setNome_ani(String nome_ani) {
        this.nome_ani = nome_ani;
    }

    public String getRaca_ani() {
        return raca_ani;
    }

    public void setRaca_ani(String raca_ani) {
        this.raca_ani = raca_ani;
    }

    public String getPorte_ani() {
        return porte_ani;
    }

    public void setPorte_ani(String porte_ani) {
        this.porte_ani = porte_ani;
    }

    public Date getDataNasc_ani() {
        return dataNasc_ani;
    }

    public void setDataNasc_ani(Date dataNasc_ani) {
        this.dataNasc_ani = dataNasc_ani;
    }

    public String getIdade_ani() {
        return idade_ani;
    }

    public void setIdade_ani(String idade_ani) {
        this.idade_ani = idade_ani;
    }

    public String getCliente_cpf() {
        return Cliente_cpf;
    }

    public void setCliente_cpf(String Cliente_cpf) {
        this.Cliente_cpf = Cliente_cpf;
    }

}
