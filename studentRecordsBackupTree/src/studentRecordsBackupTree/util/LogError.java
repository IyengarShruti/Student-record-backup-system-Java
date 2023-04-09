package studentRecordsBackupTree.util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/**
 * logs Error to console and error file.
 */
public class LogError {
    String errorFile;
    FileWriter fileWriter;
    PrintWriter printWriter;

    /**
     * Constructor for LogError class
     * @param errorFileIn
     * @throws IOException
     */
    public LogError(String errorFileIn) throws IOException{
        errorFile = errorFileIn;
        fileWriter = new FileWriter(errorFile,false);
        printWriter = new PrintWriter(fileWriter,false);   
     }


    /**
     * Output file writing
     * @param errorlist
     */
    public void writeToErrorFile(List<String> errorlist){
        
        for(String s: errorlist){
         printWriter.println(s);
         printWriter.flush();
         }

    }

    /**
     * Printing results on screen
     * @param errorlist
     */
    public void writeErrorsToConsole(List<String> errorlist) {
    for(String s: errorlist){
    System.out.println(s);
    }

  }
}


