package nl.capaxit.mybatisexamples.common.util;

/**
 * Created by jamiecraane on 30/06/16.
 */
public final class Timeit {
    private Timeit() {
    }

    public static void code(final Runnable runnable) {
        final long start = System.nanoTime();
        try {
            runnable.run();
        } finally {
            final long end = System.nanoTime();
            System.out.println("Total time: " + (end - start) / 1.0e9);
        }
    }
}
