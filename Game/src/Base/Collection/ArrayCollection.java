package Base.Collection;

import Base.GameMap;
import Base.MapLoaders.Loader;
import Base.Objects.Abstracts.AbstractFigur;
import Base.Objects.Abstracts.AbstractMovingFigur;
import Base.Objects.Enums.Directions;
import Base.Objects.Realization.Emptiness;
import Base.Objects.Realization.Player;
import Base.Objects.Realization.Wall;
import Base.Observer.CollectionPublisherImpl;

import java.util.ArrayList;
import java.util.List;

public class ArrayCollection extends CollectionPublisherImpl {
    AbstractFigur[][] data = {
            {new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness()},
            {new Wall(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall()},
            {new Wall(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness()},
            {new Wall(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness()},
            {new Emptiness(), new Wall(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness()},
            {new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness()},
            {new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness()},
            {new Wall(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(),new Wall(), new Emptiness(), new Emptiness()},
            {new Emptiness(),new Emptiness(), new Emptiness(), new Emptiness(),new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness()},
            {new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Wall()},
            {new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness()},
            {new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Wall(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness(), new Emptiness()}
    };
    private List<AbstractMovingFigur> movingObjects = new ArrayList<>();
    private Player player = new Player();

    public ArrayCollection(Loader loader, GameMap map) {
        data = loader.loading(this.data,player, map);
        initOthers();
    }
    private void initOthers() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {

                if (data[i][j] instanceof Player) {
                    player = (Player) data[i][j];
                }

                if (data[i][j] instanceof AbstractMovingFigur) {
                    movingObjects.add( (AbstractMovingFigur) data[i][j]);
                }
            }
        }
    }


    @Override
    public AbstractFigur[][] getData() {
        return data;
    }


    public AbstractFigur getFigurByCoordinate(int y, int x) {
        try {
            return data[y][x];
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void setObjectByCoordinate(int y, int x, AbstractFigur object) {
        object.setX(x);
        object.setY(y);
        data[y][x] = object;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void moveAllMovables(Directions direction) throws Exception {

        for (int i = 0; i < movingObjects.size(); i++) {
            AbstractMovingFigur movingObject =  movingObjects.get(i);
            int[] nextCoord = movingObject.move(direction);
            int y = nextCoord[0];
            int x = nextCoord[1];
            AbstractFigur nextObject = getFigurByCoordinate(x,y);

            if (movingObject.canMove(nextObject)) {
                setObjectByCoordinate(movingObject.getY(), movingObject.getX(), new Emptiness());
                setObjectByCoordinate(y, x, movingObject);
            }

        }

        notifyAllListeners();


    }


}
