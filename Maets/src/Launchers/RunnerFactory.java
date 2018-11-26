/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

/**
 *
 * @author jakec
 */
class RunnerFactory {
    
    public RunnerFactory(){
        
    }

    public RunProduct getProductRunner(String fileLocation) {
        System.out.println("file: "+fileLocation);
        if(fileLocation.contains(".txt")){
            return new RunTXT(fileLocation);
        } else if(fileLocation.contains(".jar")){
            return new RunJAR(fileLocation);
        } else {
            return new RunError();
        }
    }
}
