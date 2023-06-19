package com.silviosantana.treinododia;

public class Usuario {
    private String nome;
    private String dataN;
    private String altura;
    private String peso;
    private String email;
    private String senha;



    public Usuario(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataN() {
        return dataN;
    }

    public void setDataN(String dataN) {
        this.dataN = dataN;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(String _nome, String _dataN, String _altura, String _peso , String _email, String _senha ){

        this.nome = _nome;
        this.dataN = _dataN;
        this.altura = _altura;
        this.peso = _peso;
        this.email = _email;
        this.senha = _senha;


    }




}
