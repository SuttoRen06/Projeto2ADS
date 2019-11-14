/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oshi.oshivai;

import java.io.IOException;
//import java.nio.file.ClosedFileSystemException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author renan.sutto
 */
public class LogManager {

    //variável usada na geração do log
    Logger logger;
    
    //Método criado para gerar o log
    public LogManager() {
        
        //Váriavel para criar o log que recebe os métodos para gerar o mesmo
        logger = Logger.getLogger("MyLog");
        FileHandler fh;
        
        
        try {
  
            //Sempre que abrir em um novo computador,trocar o repositório,ou seja,criar uma pasta no computador e nomear o arquivo com ".txt" no final para ele gerar o log
            fh = new FileHandler("C:\\Users\\Aluno\\Desktop\\tentativas\\arquivo.txt");

            //classe Instanciada para fazer o log ficar com o formato "data e hora"
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            //Metódo do Logger para permitir um arquivo ser escrito.
            logger.addHandler(fh); 
            
            
            //Utilizado para exibir as informações do log,o input output,vulgo IO 
            
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Frase que será exibida na primeira linha do Log
        logger.info("Gerando Log...");
        logger.info("Conectando com banco...");
        logger.info("Conectado com o banco");
        
    }

    
    
    //Exibição dos IO capturados.
    public void log(String msg){
        logger.info(msg);
    }
    

}

