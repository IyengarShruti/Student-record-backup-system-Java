package studentRecordsBackupTree.bst;
import java.util.ArrayList;
import java.util.List;


public class NodeImpl implements IObservable, IObserver {

    List<IObserver> listOfObservers = new ArrayList<>();

    public int bNumber;
    int updatedVal;

    //description stores the ith index of the node...
    String description;
    NodeImpl left;
    NodeImpl right;
    /*
     * constructor to initialize list of observers, BNumber & description.
     */
    public NodeImpl() {
        this.right = null;
        this.left = null;
    }

    public NodeImpl(int bNumberIn) {
        this.bNumber=bNumberIn;
    }

    /*
     * @To use getters and setters for data fields
     */
    public int getbNumber(){
        return bNumber;
    }
    public void setbNumber(int bNumberIn){
        this.bNumber = bNumberIn;

    }
    public NodeImpl getLeft(){
        return left;
    }
    public void setLeft(NodeImpl left){
        this.left=left;
    }
    public NodeImpl getRight(){
        return right;
    }
    public void setRight(NodeImpl right){
        this.right=right;
    }

   
    public void addObservers(IObserver observer) {
        listOfObservers.add(observer);

    }

    
    public void removeObservers(IObserver observer) {
        listOfObservers.remove(observer);

    }

  
    public void update( int valueIn) {
        bNumber = bNumber+valueIn;
        setUpdatedVal(bNumber);
        notifyObservers(this.getupdatedVal());
    }

    public void notifyObservers(int update) {
        for(IObserver observer : listOfObservers){
            observer.update(update);
        }

    }
   
    /**
     * @param updatedValIn
     */
    private void setUpdatedVal(int updatedValIn) {
        this.updatedVal = updatedValIn;

    }
    /**
     * @return updatedVal
     */
    private int getupdatedVal() {
        return updatedVal;
    }

    public String toString() {
        return bNumber + description;
    }


}
