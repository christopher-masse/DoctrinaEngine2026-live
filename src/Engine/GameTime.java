package Engine;

import java.util.concurrent.TimeUnit;

public class GameTime {
    private final int FPS_TARGET = 60;
    private long syncTime;
    private final long gameStartTime;
    private int currentFps;
    private int fpsCount;
    private long lastSecond;

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

    private void sleep() {
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private long getSleepTime() {
        long targetTime = 1000 / FPS_TARGET;
        long sleepTime = targetTime - (getCurrentTime() - syncTime);
        return Math.max(sleepTime, 4);
    }

    public void synchronize() {
        update();
        sleep();
        synchronizeTime();
    }

    private void synchronizeTime() {
        syncTime = getCurrentTime();
    }


    private void update() {
        fpsCount++;
        long currentSecond = TimeUnit.MILLISECONDS.toSeconds(getElapsedTime());

        if (currentSecond != lastSecond) {
            currentFps = fpsCount;
            fpsCount = 0;
        }
        lastSecond = currentSecond;
    }

    public int getCurrentFps() {
        return (currentFps > 0) ? currentFps : fpsCount;
    }
}
