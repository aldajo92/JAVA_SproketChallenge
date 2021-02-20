package com.connextra.pairing.exercise1;

public class SprocketCache {

	private final SlowSprocketFactory sprocketFactory;

	public SprocketCache(SlowSprocketFactory sprocketFactory) {
		this.sprocketFactory = sprocketFactory;
	}

	public Sprocket get(Object key) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void setMaxAgeMs(long maxAgeMs) {
        throw new UnsupportedOperationException("Not implemented yet.");
	}
}
