package com.github.oshi.oshivai;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeradorLOG{
Processos javaOshi = new Processos();
    public static void main(String[] args) throws IOException {
        FileWriter arq = new FileWriter("C:\\Users\\renan.sutto\\Desktop\\LOGg.txt");
    PrintWriter gravarArq = new PrintWriter(arq);
    gravarArq.printf("+--Resultado--+%n");
    for (Integer i=1; i<=10; i++) {
        gravarArq.printf("Logzin teste");
    }
    gravarArq.printf("+-------------+%n");
    arq.close();
    }
    
 
}