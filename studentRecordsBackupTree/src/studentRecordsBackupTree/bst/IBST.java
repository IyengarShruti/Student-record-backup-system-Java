package studentRecordsBackupTree.bst;
import java.util.List;

public interface IBST {


/**
 * @param root
 * @param newnode
 */
public void insertNode(NodeImpl root, NodeImpl newnode);
/**
 * @param root
 * @param listofresults
 */
public void printInorder(NodeImpl root,List<String> listofresults);

/**
 * @return root
 */
public NodeImpl getRoot();


}