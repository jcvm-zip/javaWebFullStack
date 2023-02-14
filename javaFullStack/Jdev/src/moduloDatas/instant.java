package moduloDatas;

import java.time.Duration;
import java.time.Instant;

public class instant {
    public static void main(String[] args) throws InterruptedException {

        Instant inicio = Instant.now();

        Thread.sleep(5000);

        Instant ifinal = Instant.now();

        Duration duration = Duration.between(inicio, ifinal);

        System.out.println("Duração em nano segundos: "+ duration.toNanos());
        System.out.println("Duração em mili segundos: "+ duration.toMillis());
        System.out.println("Duração em segundos: "+ duration.toSeconds());
        System.out.println("Duração em minutos: "+ duration.toMinutes());
        System.out.println("Duração em horas: "+ duration.toHours());


    }
}
