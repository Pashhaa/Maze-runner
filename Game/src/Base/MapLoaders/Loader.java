package Base.MapLoaders;

import Base.GameMap;
import Base.Objects.*;

public interface Loader {
    public AbstractFigur[][] loading(AbstractFigur data[][], Player player, GameMap map);
}
