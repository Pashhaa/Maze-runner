package Base.MapLoaders;

public class LoaderFactory {

    public DifficultyLoader getLoader(DifficultyLoaderType type){
        DifficultyLoader difficultyLoader = null;
        switch (type) {
            case EASYLOADER:
                difficultyLoader = new EasyDifficultyLoader();
                break;
            case MEDIUMLOADER:
                difficultyLoader = new MediumDifficultyLoader();
                break;
            case HARDLOADER:
                difficultyLoader = new HardDifficultyLoader();
                break;
        }
        return difficultyLoader;
        }
    }


