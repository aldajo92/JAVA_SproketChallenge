package com.connextra.pairing.exercise1;

import java.util.HashMap;

public class SprocketCache {

	private final SlowSprocketFactory sprocketFactory;
	private HashMap<Object, Sprocket> sprocketCacheMap = new HashMap<>();

	public SprocketCache(SlowSprocketFactory sprocketFactory) {
		this.sprocketFactory = sprocketFactory;
	}

	public Sprocket get(Object key) {
		if(sprocketCacheMap.containsKey(key)){
			return sprocketCacheMap.get(key);
		}
		Sprocket sprocket = sprocketFactory.createSprocket();
		sprocketCacheMap.put(key, sprocket);
		return sprocket;
	}

	public void setMaxAgeMs(long maxAgeMs) {
        throw new UnsupportedOperationException("Not implemented yet.");
	}
}
