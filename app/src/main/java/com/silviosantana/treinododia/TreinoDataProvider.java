package com.silviosantana.treinododia;

public class TreinoDataProvider {
    private  int listaIcones;
    private String listatreinos;
    private String listainiciais;

    public TreinoDataProvider(int listaIcones, String listatreinos, String listainiciais)
    {
        this.setlistaIcones(listaIcones);
        this.setlistatreinos(listatreinos);
        this.setlistainiciais(listainiciais);
    }

    public int getlistaIcones() {
        return listaIcones;
    }

    public void setlistaIcones(int listaIcones) {
        this.listaIcones = listaIcones;
    }

    public String getlistatreinos() {
        return listatreinos;
    }

    public void setlistatreinos(String listatreinos) {
        this.listatreinos = listatreinos;
    }

    public String getlistainiciais() {
        return listainiciais;
    }

    public void setlistainiciais(String listainiciais) {
        this.listainiciais = listainiciais;
    }
}
