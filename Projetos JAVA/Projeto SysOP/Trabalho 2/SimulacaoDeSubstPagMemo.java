import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulacaoDeSubstPagMemo {
    public static void main(String[] args) {
        String[] data = { "red", "green", "blue", "red", "yellow", "red", "black", "red", "blue", "white", "green" };
        final int size = 4;

        System.out.println("\n##### Teste com FIFO #####");
        fifo(size, data);

        System.out.println("\n##### Teste com LRU #####");
        lru(size, data);

        System.out.println("\n##### Teste com LFU #####");
        lfu(size, data);
    }

    static void fifo(final int size, final String[] data) {
        ArrayDeque<String> cache = new ArrayDeque<>();

        int misses = 0, hit = 0, access = 0;

        for (String d : data) {
            if (!cache.contains(d)) {
                if (cache.size() < size) {
                    cache.add(d);
                } else {
                    cache.remove();
                    cache.add(d);
                }

                misses++;
            } else {
                hit++;
            }

            access++;

            System.out.printf("access: %d, hit: %d, misses: %d >>> %s\n[ ", access, hit, misses, d);
            cache.forEach((x) -> System.out.print(x + " "));
            System.out.println("]");
        }
    }

    static void lru(final int size, final String[] data) {
        ArrayDeque<String> cache = new ArrayDeque<>();

        int misses = 0, hit = 0, access = 0;

        for (String d : data) {
            if (!cache.contains(d)) {
                if (cache.size() < size) {
                    cache.add(d);
                } else {
                    cache.remove();
                    cache.add(d);
                }

                misses++;
            } else {
                cache.remove(d);
                cache.add(d);

                hit++;
            }

            access++;

            System.out.printf("access: %d, hit: %d, misses: %d >>> %s\n[ ", access, hit, misses, d);
            cache.forEach((x) -> System.out.print(x + " "));
            System.out.println("]");
        }
    }

    static void lfu(final int size, final String[] data) {
        class DataWrapper implements Comparable<DataWrapper> {
            private final String data;
            private int frequency;

            DataWrapper(String data) {
                this.data = data;
                incrementFrequency();
            }

            void incrementFrequency() {
                this.frequency++;
            }

            @Override
            public boolean equals(Object o) {
                DataWrapper dw = (DataWrapper) o;
                return dw.data.equals(this.data);
            }

            @Override
            public int compareTo(DataWrapper o) {
                if (this.frequency > o.frequency)
                    return 1;
                else if (this.frequency < o.frequency)
                    return -1;
                else
                    return 0;
            }

            @Override
            public String toString() {
                return data;
            }
        }

        List<DataWrapper> cache = new ArrayList<>();
        List<DataWrapper> temp = new ArrayList<>();

        int misses = 0, hit = 0, access = 0;

        for (String d : data)
            temp.add(new DataWrapper(d));

        for (DataWrapper d : temp) {
            if (!cache.contains(d)) {
                if (cache.size() < size) {
                    cache.add(d);
                } else {
                    cache.remove(0);
                    cache.add(d);
                }

                misses++;
            } else {
                cache.get(cache.indexOf(d)).incrementFrequency();
                hit++;
            }

            Collections.sort(cache);
            access++;

            System.out.printf("access: %d, hit: %d, misses: %d >>> %s\n[ ", access, hit, misses, d);
            cache.forEach((x) -> System.out.printf("%s(%d) ", x, x.frequency));
            System.out.println("]");
        }
    }
}