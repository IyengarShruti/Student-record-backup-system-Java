package studentRecordsBackupTree.bst;

public interface IObservable {

    /**
     * @param observer
     */
    public void addObservers(IObserver observer);
    /**
     * @param observer
     */
    public void removeObservers(IObserver observer);
    /**
     * @param update
     */
    public void notifyObservers(int update);
}
