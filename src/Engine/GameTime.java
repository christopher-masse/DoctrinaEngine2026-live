package Engine;

import java.util.concurrent.TimeUnit;

public class GameTime {
    private final int SLEEP = 25;
    private long syncTime;
    private final long gameStartTime;

    public GameTime() {
        syncTime = getCurrentTime();
        gameStartTime = getCurrentTime();
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return getCurrentTime() - gameStartTime;
    }

    public String getElapsedFormattedTime() {
        long time = getElapsedTime();
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        time -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        time -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void sleep() {
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private long getSleepTime() {
        long sleepTime = SLEEP - (getCurrentTime() - syncTime);
        syncTime = getCurrentTime();
        return Math.max(sleepTime, 4);
    }
}
