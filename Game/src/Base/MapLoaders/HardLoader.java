package Base.MapLoaders;

public class HardLoader extends Loader{
    static String[] array = {"N","N","N","N","GG","E","E", "M","N","N","N"};
    static int goldCount = 5;
    static int botCount = 8;
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
