package com.connextra.pairing.exercise1;

public class ThreadSprocketCache implements Runnable {

    private final SprocketCache sprocketCache;
    private final String key;
    private Sprocket sprocket;

    public ThreadSprocketCache(SprocketCache sprocketCache, String key) {
        this.sprocketCache = sprocketCache;
        this.key = key;
    }

    public Sprocket getSprocket() {
        return sprocket;
    }

    @Override
    public void run() {
        sprocket = sprocketCache.get(key);
    }
}
