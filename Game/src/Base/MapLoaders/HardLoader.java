package Base.MapLoaders;

public class HardLoader implements Loader{
    final static String[] array = {"N","N","N","N","GG","M","M","N","N","N"};
    final static short goldCount = 5;
    final static short botCount = 10;
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
