package com.connextra.pairing.exercise1;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

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
    }
	
	@Test
	@Ignore
	public void testCacheTimeout() {
	}	

    @Test
    @Ignore
    public void testThreadSafe() {
    }
}
