package Base.MapLoaders;

public interface Loader {
    final static String[] array = new String[0];
    final static short goldCount = 0;
    final static short botCount = 0;
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
