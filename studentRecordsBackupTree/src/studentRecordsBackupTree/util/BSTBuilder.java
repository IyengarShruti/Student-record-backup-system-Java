package studentRecordsBackupTree.util;
import studentRecordsBackupTree.bst.BST;
import studentRecordsBackupTree.bst.NodeImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
/*
 * This is a helper class to invoke different
 *  parts of the code.
 */
public class BSTBuilder {

    private BST main;
    private BST backup1;
    private BST backup2;
    private int updateIn;
    private NodeImpl mainNode;
    private NodeImpl backup1Node;
    private NodeImpl backup2Node;
    public int bNumber;
    Results results;
    String bstOutputFile;
    String errorLogFile;
    BST bstMain = new BST();
    BST bstBackup1 = new BST();
    BST bstBackup2 = new BST();
    
    
    /**
     * Constructor for BSTBuilder
     * @param Filename1: bstOutput.txt
     * @param UPDATE_VALUEIn
     * @throws IOException
     */
    public BSTBuilder(String Filename1, int UPDATE_VALUEIn) throws IOException {

        main = bstMain;
        backup1= bstBackup1;
        backup2= bstBackup2;
        bstOutputFile=Filename1;
        updateIn = UPDATE_VALUEIn;
        results = new Results(bstOutputFile);    

    }

    /**
     * @param Filename1
     * @param Filename2
     * @throws IOException
     */
    public void FileInvokerMethod(String Filename1, String Filename2) throws IOException {
        errorLogFile = Filename2;
        FileProcessor fp = new FileProcessor(this, errorLogFile);
        fp.readInput(Filename1);

    }

        
    /**
     *  helper method for inserting data...
     * @param bNumber
     * @throws IOException
     */
    public void helperForInsert(int bNumber) {
 
        mainNode = new NodeImpl();
        backup1Node = new NodeImpl();
        backup2Node = new NodeImpl();
        mainNode.setbNumber(bNumber);
        backup1Node.setbNumber(bNumber);
        backup2Node.setbNumber(bNumber);
        mainNode.addObservers(backup1Node);
        mainNode.addObservers(backup2Node);
        main.insert(mainNode);
        backup1.insert(backup1Node);
        backup2.insert(backup2Node);
           
    }

    /**
     * helper method for printing...
     * @throws IOException
     */
    public void helperforPrint() throws IOException {
        List<String> writelist = new ArrayList<>();

        // Inorder traversal
        System.out.println("*************INORDER TRAVERSAL****************");
        results.writeToFile(Collections.singletonList("*************INORDER TRAVERSAL****************"));
        getTraversalResult("Main Tree:    ", writelist);
        getTraversalResult("Backup1 Tree: ", writelist);
        getTraversalResult("Backup2 Tree: ", writelist);
        // Sum of all the B-Numbers in each trere
        System.out.println("******SUM OF ALL BNUMBERS BEFORE INCREMENT*****");
        results.writeToFile(Collections.singletonList("*************SUM OF ALL BNUMBERS BEFORE INCREMENT****************"));
        getSumResults(writelist);
        // Sum of all the B-Numbers after increment
        System.out.println("******SUM OF ALL BNUMBERS AFTER INCREMENT*****");
        // //Performing update on only Main tree...to check Observer Pattern
        main.updateNode(main.getRoot(),updateIn);
        results.writeToFile(Collections.singletonList("*************SUM OF ALL BNUMBERS After INCREMENT****************"));
        getSumResults(writelist);

    }

    /**
     * Method to append tree name with the list of results
     * @param treeName
     * @param writelist
     * @return
     */
    public ArrayList<String> getAppendedList(String treeName, List<String> writelist){
        StringJoiner joiner = new StringJoiner(",");
        writelist.forEach(item -> joiner.add(item));
        ArrayList<String> appendedList = new ArrayList<>();
        appendedList.add(treeName+joiner.toString());
        return appendedList;
    }

    /**
     * For writing sum of bNumbers to File
     * @param writelist
     * @param result1
     * @param result2
     * @param result3
     */
    public void writeSumOfbNumbersToFile(List<String> writelist,String result1, String result2, String result3){
        writelist.add(result1);
        writelist.add(result2);
        writelist.add(result3);
        results.writeToFile(writelist);
        writelist.clear();
    }
    
    /**
     * For writing traversal results
     * @param treeName
     * @param writelist
     */
    public void getTraversalResult(String treeName, List<String> writelist){
    
        main.printInorder(main.getRoot(),writelist);
        List<String>appendedList = getAppendedList(treeName, writelist);
        System.out.println(appendedList.get(0));
        results.writeToFile(appendedList);
        writelist.clear();

    }
    /**
     * Fetches the sum and calls the writeSumOfbNumberToFile
     * @param writelist
     */
    public void getSumResults(List<String> writelist){
        String result1 = "Main Tree:    "+ main.summation(main.getRoot());
        String result2 = "Backup1 Tree: "+ backup1.summation(main.getRoot());
        String result3 = "Backup2 Tree: "+ backup2.summation(main.getRoot());
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        writeSumOfbNumbersToFile(writelist, result1,result2,result3);
        writelist.clear();
       
    }
}


