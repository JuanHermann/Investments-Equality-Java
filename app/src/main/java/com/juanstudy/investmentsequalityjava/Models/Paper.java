package com.juanstudy.investmentsequalityjava.Models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "Papel")
public class Paper {

    @Attribute(name = "Codigo")
    private String codigo;
    @Attribute(name = "Nome")
    private String nome;
    @Attribute(name = "Ibovespa")
    private String ibovespa;
    @Attribute(name = "Data")
    private String data;
    @Attribute(name = "Abertura")
    private String abertura;
    @Attribute(name = "Minimo")
    private String minimo;
    @Attribute(name = "Maximo")
    private String maximo;
    @Attribute(name = "Medio")
    private String medio;
    @Attribute(name = "Ultimo")
    private String ultimo;
    @Attribute(name = "Oscilacao")
    private String oscilacao;

    public Paper(String codigo, String nome, String ibovespa, String data, String abertura, String minimo, String maximo, String medio, String ultimo, String oscilacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.ibovespa = ibovespa;
        this.data = data;
        this.abertura = abertura;
        this.minimo = minimo;
        this.maximo = maximo;
        this.medio = medio;
        this.ultimo = ultimo;
        this.oscilacao = oscilacao;
    }

    public Paper() {
    }

    public Paper(String codigo, String ultimo) {
        this.codigo = codigo;
        this.ultimo = ultimo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIbovespa() {
        return ibovespa;
    }

    public void setIbovespa(String ibovespa) {
        this.ibovespa = ibovespa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAbertura() {
        return abertura;
    }

    public void setAbertura(String abertura) {
        this.abertura = abertura;
    }

    public String getMinimo() {
        return minimo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }

    public String getMaximo() {
        return maximo;
    }

    public void setMaximo(String maximo) {
        this.maximo = maximo;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getUltimo() {
        return ultimo;
    }

    public void setUltimo(String ultimo) {
        this.ultimo = ultimo;
    }

    public String getOscilacao() {
        return oscilacao;
    }

    public void setOscilacao(String oscilacao) {
        this.oscilacao = oscilacao;
    }
}
