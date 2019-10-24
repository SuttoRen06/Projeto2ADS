/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;
import java.net.InetAddress;
import java.net.UnknownHostException;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.hardware.CentralProcessor;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;
/**
 *
 * @author lucas.martins
 */
public class OshiV2 {
    static DadosPc dpc = new DadosPc();
    
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    ComputerSystem cp = hal.getComputerSystem();
    CentralProcessor processor =  hal.getProcessor();
    String hostname;
    String nomeUserMaq;


    
    
    //Especificações da máquina
    public String getManufacture(){
        return cp.getManufacturer();
    }
    public String getModel(){
        return cp.getModel();
    }
    public String getProcessor(){
        return processor.toString();
    }
    public String getSO() throws UnknownHostException{
        return hostname = InetAddress.getLocalHost().getHostName();
    }
    public String getUserMaq(){
        return nomeUserMaq = System.getProperty("user.name");
    }
    
    //Recursos Operacionais
    public Integer getCpu(){
        double getCpuPorcent = 0.0;
        int convertCpuPorcent = 0;
        long[][] prevProcTicks = processor.getProcessorCpuLoadTicks();
        // Wait a second...
        Util.sleep(1000);
        double[] load = processor.getProcessorCpuLoadBetweenTicks(prevProcTicks);

        
        for (double avg : load) {
            
            getCpuPorcent += (avg/2)*100;
//            result = String.valueOf(contas);
            convertCpuPorcent = (int) getCpuPorcent;
            

//            procCpu.append(String.format(" %.1f%%", avg * 100));
        }
//        Integer getLPC = processor.getLogicalProcessorCount();
//        return getLPC.toString();
            return convertCpuPorcent;
    
    }
    public String capturaDisco(){
        long livre = 0;
        FileSystem fs = os.getFileSystem();
        OSFileStore[] fsa = fs.getFileStores();
        
        for (OSFileStore oSFileStore : fsa){
            livre+=oSFileStore.getUsableSpace();
        }
        return (FormatUtil.formatBytes(livre));
    }
}
