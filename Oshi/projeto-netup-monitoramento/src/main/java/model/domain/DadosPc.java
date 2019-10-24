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
public class DadosPc {
    OshiV2 oshiv2 = new OshiV2();
//Variaveis   
    private static String userPc;
    private static String nomeMaq;
    private static String so;
    private static String cpu;
    private static String discoDisp;
    private static String discoCheio;
    private static String memoria;
// Construtor
//    public DadosPc(String userPc, String nomeMaq, String so, String cpu, String discoDisp, String discoCheio, String memoria) {
//        this.userPc = userPc;
//        this.nomeMaq = nomeMaq;
//        this.so = so;
//        this.cpu = cpu;
//        this.discoDisp = discoDisp;
//        this.discoCheio = discoCheio;
//        this.memoria = memoria;
//    }

// Getters and Setters
    public static void main(String[] args) {

    }
    public String getUserPc() {
        return userPc;
    }

    public void setUserPc(String userPc) {
        System.out.println(userPc);
        DadosPc.userPc = userPc;
    }

    public String getNomeMaq() {
        return nomeMaq;
    }

    public void setNomeMaq(String nomeMaq) {
        DadosPc.nomeMaq = nomeMaq;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        DadosPc.so = so;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        DadosPc.cpu = cpu;
    }

    public String getDiscoDisp() {
        return discoDisp;
    }

    public void setDiscoDisp(String discoDisp) {
        this.discoDisp = discoDisp;
    }

    public String getDiscoCheio() {
        return discoCheio;
    }

    public void setDiscoCheio(String discoCheio) {
        DadosPc.discoCheio = discoCheio;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        DadosPc.memoria = memoria;
    }
    
}
