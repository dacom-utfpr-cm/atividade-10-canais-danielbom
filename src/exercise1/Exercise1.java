package exercise1;

import java.io.IOException;
import java.nio.channels.Pipe;

/**
 * Implementar o problema do produtor-consumidor usando Java NIO: Pipe,
 * Pipe.SinkChannel e Pipe.SourceChannel.
 * 
 * @author daniel
 *
 */
public class Exercise1 {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();

        Thread thread;
        for (int i = 0; i < 2; i++) {
            thread = new Thread(new Consumer(pipe.source()), i + "");
            thread.setDaemon(true);
            thread.start();
        }

        new Produtor(pipe.sink(), 100).run();
    }
}
