package studentRecordsBackupTree.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Processes input file
 */
public class FileProcessor {

    List<String> errorList;
    LogError logObject;
    BSTBuilder bstBuilder;

/**
 * Constructor for FileProcessor
 * @param bstBuilderIn
 * @param errorLogFile
 * @throws IOException
 */
public FileProcessor(BSTBuilder bstBuilderIn, String errorLogFile) throws IOException{
        bstBuilder=bstBuilderIn;
        errorList = new ArrayList<>();
        logObject = new LogError(errorLogFile);
        }


/**
 * @param Filename
 * @throws IOException
 */
public void readInput(String Filename ) throws IOException {

        
        System.out.println("Reading Input File: "+Filename);
        // Reads the input file 
        File file = new File(Filename);

        try (Scanner readFile = new Scanner(file)) {
        int bNumber = 0;
        while (readFile.hasNextInt()) {
        bNumber = readFile.nextInt();
        //call the helper method in BSTBuilder for inserting...
        bstBuilder.helperForInsert(bNumber);
        }
        }catch (FileNotFoundException e) {
        String error = "File not found!";
        errorList.add(error);
        logObject.writeErrorsToConsole(errorList);
        logObject.writeToErrorFile(errorList);
        MyLogger.writeMessage(error, MyLogger.DebugLevel.FILE_PROCESSOR);
        System.exit(1);
        }       

        
     }

}
