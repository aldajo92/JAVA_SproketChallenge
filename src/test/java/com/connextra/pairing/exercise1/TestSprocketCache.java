package com.connextra.pairing.exercise1;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestSprocketCache {

	private SlowSprocketFactory sprocketFactory = new SlowSprocketFactory();
	
	@Test
	public void testCacheReturnsASprocket() {
		SprocketCache cache = new SprocketCache(sprocketFactory);
		
		Sprocket sprocket = cache.get("key");
		assertNotNull(sprocket);
	}

	@Test
    @Ignore
	public void testCacheReturnsSameObjectForSameKey() {
		SprocketCache cache = new SprocketCache(sprocketFactory);
		
		Sprocket sprocket1 = cache.get("key");
		Sprocket sprocket2 = cache.get("key");
		
		assertEquals("cache should return the same object for the same key", sprocket1, sprocket2);
		assertEquals("factory's create method should be called once only", 1, sprocketFactory.getMaxSerialNumber());
	}

    @Test
    @Ignore
    public void testCacheReturnsDifferentObjectsForDifferentKeys() {
		SprocketCache cache = new SprocketCache(sprocketFactory);

		Sprocket sprocket1 = cache.get("key1");
		Sprocket sprocket2 = cache.get("key2");

		assertNotEquals("cache should return the same object for different key", sprocket1, sprocket2);
		assertEquals("factory's create method should be called twice", 2, sprocketFactory.getMaxSerialNumber());
    }
	
	@Test
	@Ignore
	public void testCacheTimeout() throws InterruptedException {
		SprocketCache cache = new SprocketCache(sprocketFactory);

		Sprocket sprocket = cache.get("key");

		TimeUnit.MILLISECONDS.sleep(100);

		assertNotNull(sprocket);
	}

    @Test
    @Ignore
    public void testThreadSafe() throws InterruptedException {
		SprocketCache sprocketCache = new SprocketCache(sprocketFactory);

		ThreadSprocketCache threadSprocketCache1 = new ThreadSprocketCache(sprocketCache, "key1");
		ThreadSprocketCache threadSprocketCache2 = new ThreadSprocketCache(sprocketCache, "key2");
		Thread th1 = new Thread(threadSprocketCache1);
		Thread th2 = new Thread(threadSprocketCache2);

		th1.start();
		th2.start();

		th1.join();
		th2.join();

		assertEquals(sprocketCache.get("key1"), threadSprocketCache1.getSprocket());
		assertEquals(sprocketCache.get("key2"), threadSprocketCache2.getSprocket());
    }
}
