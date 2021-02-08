package Base.MapLoaders;

public interface Loader {
    static String[] array = {"N","N","N","N","N","N","N","N","N","N","N"};
    static short goldCount = 0;
    static short botCount = 0;
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
