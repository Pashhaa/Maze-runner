package Base.Collection;


import Base.Objects.Abstracts.AbstractFigur;
import Base.Objects.Enums.Direction;
import Base.Objects.Realization.Player;
import Base.Observer.CollectionPublisher;

public interface GameCollection extends CollectionPublisher {
    AbstractFigur[][] getData();

    AbstractFigur getFigurByCoordinate(int y, int x);

    void setObjectByCoordinate(int y, int x, AbstractFigur object);

    Player getPlayer();

    void moveAllMovables(Direction direction) throws Exception;
}
