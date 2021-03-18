package Base.Collection;


import Base.Objects.AbstractFigur;
import Base.Objects.Player;
import Base.Observer.CollectionPublisher;

public interface GameCollection extends CollectionPublisher {
    AbstractFigur[][] getData();

    AbstractFigur getFigurByCoordinate(int y, int x);

    void setObjectByCoordinate(int y, int x, AbstractFigur object);

    Player getPlayer();

    void moveAllMovables(int direction) throws Exception;
}
