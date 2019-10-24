/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oshi.oshivai;

import java.util.Arrays;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

/**
 *
 * @author renan.sutto
 */




public class Processos {
     //Cria uma variavel si do tipo SystemInfo(biblioteca do oshi)
     SystemInfo si = new SystemInfo();
     //Cria uma variavel os do tipo OperatingSystem(biblioteca do oshi)  
     OperatingSystem os = si.getOperatingSystem();
     //Cria uma variavel hal do tipo HardwareAbstractionLayer(biblioteca do oshi)
     HardwareAbstractionLayer hal = si.getHardware();
     private static String cpu;
     private String processos;
     //Cria um stringbuilder responsavel por gerar um String formatado 
     //atraves da lista de array que o oshi captura em processos 
     static StringBuilder sb = new StringBuilder();
  
     //metodo responsavel por atribuir os processos da variavel catchProcesso, na variavel global processos
          public void pegarDados()
     {
         
         this.processos = catchProcesso(os, hal.getMemory());
     }
     //Variavel com parametros recebidos da biblioteca do oshi 
     //responsavel por gerar o array com processos do computador 
     private String catchProcesso(final OperatingSystem os, final GlobalMemory memory)
     {
         //é criado um novo stringbuilder para ele ser executado novamente a 
         //cada vez que o processo for capturado (evitando a concatenação)
         StringBuilder stringB = new StringBuilder();
         final List<OSProcess> proc;//cria uma lista de array com os processos do sitema
         proc = Arrays.asList(os.getProcesses(15, OperatingSystem.ProcessSort.CPU));//atribui na variavel os processos
         for (int i = 0; i < proc.size(); i++)//executa um for enquanto o indice for menor que a quantidade de processos na lista
         {
             final OSProcess osP = proc.get(i); //ordena os processos
            String pid = String.valueOf(osP.getProcessID()); //atribui na variavel o valor do processo que estava no array
            String porcentagemCpu = String.valueOf(100d * (osP.getKernelTime()//atribui na variavel a porcentagem da cpu que estava no array 
            + osP.getUserTime()) / osP.getUpTime()).substring(0, 7);
            Double porcentagemMem = 100d * osP.getResidentSetSize() / memory.getTotal();
            String tamanhoAtual = FormatUtil.formatBytes(osP.getResidentSetSize()); //atribui na variavel o tamanho atual do processo na memoria
            String nome = osP.getName();//atribuiu na variavel o nome do processo
            
            stringB.append(String.format("\n%20s %20s %20.1f %-20s %10s",
            pid,
            porcentagemCpu,
            porcentagemMem,
            tamanhoAtual,
            nome));// responsavel por manipular o stringbuilder a formatar de maneira correta, atribuindo todos os valores nas variaveis determinadas
         }
         return stringB.toString();// retorna a variavel strinB o string final concatenado com todas as variaveis e formatado de maneira correta
     }
     

     public String capturaMemoria()
     {
     GlobalMemory mem = hal.getMemory();
     return FormatUtil.formatBytes(mem.getAvailable());// retorna memoria disponivel capturada pela oshi
     }
     
     public String capturaCpu()
     {
         CentralProcessor pro = hal.getProcessor();
         long[] ticks = pro.getSystemCpuLoadTicks();
         Util.sleep(1000);
         cpu = String.format("%.2f%%", pro.getSystemCpuLoadBetweenTicks(ticks)*100);
         return String.format("%.2f%%", pro.getSystemCpuLoadBetweenTicks(ticks)*100); // retorna uso da cpu capturado pelo oshi
     }
     
     public String capturaDisco() {
         long livre = 0;
         FileSystem fs = os.getFileSystem();
         OSFileStore[] fsA = fs.getFileStores();
         for (OSFileStore oSFileStore : fsA)
         {
             livre += oSFileStore.getUsableSpace();
         }
         return FormatUtil.formatBytes(livre); // retorna espaço em disco disponivel 
     }
      public String getProcessos() {
        return processos;// cria um getter para retornar a variavel global 
        //"processos" que esta sendo manipulada pela variavel catchprocesso
    }
    
}
