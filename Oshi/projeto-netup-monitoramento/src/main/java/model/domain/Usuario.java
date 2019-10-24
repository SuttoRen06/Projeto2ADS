/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;


/**
 *
 * @author lucas.martins
 */
public class Usuario {
    private Integer id;
    private String nome;
    private String senha = "admin";
    private String email = "admin@teste.com";

    public Boolean logar(String email, String senha){
        if(email.equals(this.email)&&senha.equals(this.senha)){
        return true;
        }else{
        return false;
        }
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
