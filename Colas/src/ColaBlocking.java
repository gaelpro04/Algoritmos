import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class ColaBlocking extends ArrayBlockingQueue {

    public ColaBlocking(int capacity) {
        super(capacity);
    }

    @Override
    public Stream parallelStream() {
        return super.parallelStream();
    }

    @Override
    public Object[] toArray(IntFunction generator) {
        return super.toArray(generator);
    }

    @Override
    public Stream stream() {
        return super.stream();
    }

    public void put(Object o) throws InterruptedException {
        Thread monitor = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println("hilo bloqueado no hay espacio");
            } catch (InterruptedException ignored) {}
        });

        monitor.start();

        super.put(o);

        monitor.interrupt();
    }


    public Object take() throws InterruptedException {
        return Objects.requireNonNull(super.take());

    }
}
