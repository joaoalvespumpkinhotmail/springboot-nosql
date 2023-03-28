package com.pumpkin.nosql.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "ProductDB")
public class Product {

    @Id
    private long id;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String name;
    private String description;

    private String preco_venda;

    private String valor;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getValor(){
        return valor;
    }

    public void setValor(String valor){
        this.valor = valor;
    }

    public String getPreco_venda(){
        return preco_venda;
    }

    public void setPreco_venda(String preco_venda){
        this.preco_venda = preco_venda;
    }
}
