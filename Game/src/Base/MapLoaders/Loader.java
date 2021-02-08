package Base.MapLoaders;

public abstract class Loader {
    static String[] array;
    static int goldCount;
    static int botCount;

    public static String[] getArray() {
        return array;
    }

    public static int getGoldCount() {
        return goldCount;
    }

    public static int getBotCount() {
        return botCount;
    }
}
