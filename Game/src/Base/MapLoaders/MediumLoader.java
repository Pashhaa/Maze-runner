package Base.MapLoaders;

public class MediumLoader implements Loader{
    static String[] array = {"N","N","N","N","N","GG","E", "M","N","N","N"};
    static short goldCount = 8;
    static short botCount = 5;
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
