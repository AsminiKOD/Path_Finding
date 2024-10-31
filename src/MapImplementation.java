public class MapImplementation {
    private int[][] keys;
    private int[][] values;
    private int size;
    private static final int CAPACITY = 16;

    public MapImplementation() {
        keys = new int[CAPACITY][2];
        values = new int[CAPACITY][2];
        size = 0;
    }

    public void put(int[] key, int[] value) {
        if (size == keys.length)
            Resize_Arrays();
        keys[size][0] = key[0];
        keys[size][1] = key[1];
        values[size][0] = value[0];
        values[size][1] = value[1];
        size++;
    }

    public int[] get(int[] key) {
        for (int i = size - 1; i >= 0; i--) {
            if (keys[i][0] == key[0] && keys[i][1] == key[1]) {
                int[] outCome = new int[2];
                outCome[0] = values[i][0];
                outCome[1] = values[i][1];
                return outCome;
            }
        }
        return null;
    }
    private void Resize_Arrays() {
        int newCapacity = keys.length * 2;
        int[][] newKeys = new int[newCapacity][2];
        int[][] newValues = new int[newCapacity][2];
        for (int i = 0; i < size; i++) {
            newKeys[i][0] = keys[i][0];
            newKeys[i][1] = keys[i][1];
            newValues[i][0] = values[i][0];
            newValues[i][1] = values[i][1];
        }
        keys = newKeys;
        values = newValues;
    }
}
