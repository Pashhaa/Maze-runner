package Base.MapLoaders;

import Base.GameMap;
import Base.Objects.Abstracts.AbstractFigur;
import Base.Objects.Realization.Player;

public interface Loader {
    public AbstractFigur[][] loading(AbstractFigur data[][], Player player, GameMap map);
}
