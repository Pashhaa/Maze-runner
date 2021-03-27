package Base.Strategy;

import Base.Collection.GameCollection;
import Base.Objects.Abstracts.AbstractMovingFigur;
import Base.Objects.Enums.Direction;

public interface MovingStrategy {

    Direction getDirection(GameCollection collection, AbstractMovingFigur movingFigur);
}
