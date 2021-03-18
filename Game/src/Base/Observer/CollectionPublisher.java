package Base.Observer;

public interface CollectionPublisher {

    void notifyAllListeners();

    void addListener(CollectionSubscriber listener);
}
