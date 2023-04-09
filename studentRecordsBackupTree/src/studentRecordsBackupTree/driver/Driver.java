package studentRecordsBackupTree.driver;
import studentRecordsBackupTree.util.BSTBuilder;
import studentRecordsBackupTree.util.LogError;
import studentRecordsBackupTree.util.MyLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * BST-Observer Pattern
 * @author Shruti Iyengar
 *
 */
public class Driver {
	public static void main(String[] args) throws IOException {

		//Error list for storing errors during the run time and send it to Logerror Class
		List<String> errorList = new ArrayList<>();
		LogError logObject;
		LogError logObject1;
		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
	    if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			String error = "Error: Incorrect number of arguments. Program accepts 5 argumnets.";
			errorList.add(error.toString());
			logObject1 =new LogError(args[2]);
			logObject1.writeErrorsToConsole(errorList);
			logObject1.writeToErrorFile(errorList);
			MyLogger.writeMessage(error, MyLogger.DebugLevel.MAIN);
			System.exit(0);
		}
		
		int debug_Level=0;
		int UPDATE_VALUE=0;
		String bstInput = args[0];
		String bstOutput = args[1];
		String errorLog = args[2];
		logObject = new LogError(errorLog);
		try{
		debug_Level = Integer.parseInt(args[3]);
		UPDATE_VALUE = Integer.parseInt(args[4]);
		}catch(NumberFormatException e){

		/**
		 * Error logging for wrong format of 
		 * the command line argument
		 */
			String error ="Invalid format entered";
			errorList.add(error.toString());
			logObject.writeErrorsToConsole(errorList);
			logObject.writeToErrorFile(errorList);
			System.exit(1);
		}
		MyLogger.setDebugValue(debug_Level);

		/**
		 * Error logging for wrong input file name
		 */
		if(!args[0].equals("bstInput.txt")){

			String error = "File not found";
			errorList.add(error.toString());
			logObject.writeErrorsToConsole(errorList);
			logObject.writeToErrorFile(errorList);
			System.exit(1);

		}
	else{
			//Invoking only BSTBuilder here
			BSTBuilder builderObj = new BSTBuilder(bstOutput, UPDATE_VALUE);
			builderObj.FileInvokerMethod(bstInput, errorLog);
			builderObj.helperforPrint();
			

		}
	}
}

