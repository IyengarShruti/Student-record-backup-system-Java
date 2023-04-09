package studentRecordsBackupTree.bst;
import java.util.List;
/**
 * This class follows BST rules to insert node, print node 
 * and sum of nodes
 */
public class BST implements IBST {

    int sum =0;
    NodeImpl root;

    /**
     * Constructor for BST
     */
    public BST(){

        root= null;
    }

    /**
     * @param nodeIn
     */
    public void insert(NodeImpl nodeIn) {
        if (root == null) {
            this.root = nodeIn;
        }
        else {
            insertNode(root, nodeIn);
        }

    }

    /**
     * @return root
     */
    @Override
    public NodeImpl getRoot() {
        return root;
    }



    /**
     * @param node
     * @param newnode
     */
    public void insertNode(NodeImpl node, NodeImpl newnode) {
        if(newnode.getbNumber() > node.getbNumber()){
            if(node.getRight() != null){
                insertNode(node.getRight(),newnode);
            }
            else {
                node.setRight(newnode);

            }
        }
        else{
            if(node.getLeft() != null){
                insertNode(node.getLeft(),newnode);

            }
            else {
                node.setLeft(newnode);

            }
        }

    } 
    /**
     * printing in order
     * @param newnode
     * @param listofresults
     */
    public void printInorder(NodeImpl newnode,List<String> listofresults){
        if(newnode != null) {
            printInorder(newnode.getLeft(),listofresults);
            listofresults.add(newnode.getbNumber()+"");
            printInorder(newnode.getRight(),listofresults);

        }
        
    }
    /**
     * updates the value given from command line
     * @param node
     * @param update
     * @return
     */
    public int updateNode(NodeImpl node, int update) {
        if (node != null) {
            updateNode(node.getLeft(), update);
            node.update(update);
            updateNode(node.getRight(), update);
        }
        return 0;
    }

    /**
     * method to compute the sum
     * @param newNode
     * @return sumValue
     */
    public int summation(NodeImpl newNode){

        if(newNode != null){

            return newNode.getbNumber() + this.summation(newNode.getLeft()) + this.summation(newNode.getRight());

        }
        return 0;
    }

  }

