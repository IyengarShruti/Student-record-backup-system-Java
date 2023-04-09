package studentRecordsBackupTree.util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Class to write results to file and terminal
 */
public class Results implements FileDisplayInterface, StdOutDisplayInterface {

     String bstOutput;
     String errorLogFile;
     FileWriter fileWriter;
     PrintWriter printWriter;
     
    /**
     * @param bstOutputIn
     * @param errorLogFileIn
     * @throws IOException
     */
    public Results(String bstOutputIn) throws IOException {
        
        this.bstOutput = bstOutputIn;
        // clearFile(bstOutput,errorLogFile);
        fileWriter = new FileWriter(bstOutputIn,false);
        printWriter = new PrintWriter(fileWriter,false);
           
    }
    
    /**
     * @param writelist
     */
    public void writeToFile(List<String> writelist){
        
           for(String s: writelist){
            printWriter.println(s);
            printWriter.flush();
       }
    }

    /**
     * @param writelist
     */
    public void writeToConsole(List<String> writelist) {
        for(String s: writelist){
        System.out.print(s);
        }
        
    }
    
}
        
