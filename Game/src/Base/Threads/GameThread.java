package Base.Threads;

import Base.Collection.GameCollection;
import Base.Objects.Enums.ObjectType;
import Base.Strategy.RandomStrategy;

import java.util.Collection;

public class GameThread extends Thread{

    private GameCollection collection;

    public GameThread(GameCollection collection) {
        this.collection = collection;
    }

    @Override
    public void run() {
        for (; ; ) {
            collection.moveMovableFigur(ObjectType.BOT, new RandomStrategy());
        }
    }
}
