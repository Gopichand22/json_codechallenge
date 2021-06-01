package com.mindtree.utils.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import com.mindtree.utils.RandomNumber;

public class RandomNumberImpl implements RandomNumber {

	@Override
	public int generateNumber() {
		Random random;
		int number = 0;
		try {
			random = SecureRandom.getInstanceStrong();
			number = random.nextInt();
		} catch (NoSuchAlgorithmException  e) {
			// TODO: handle exception
		}
		return Math.abs(number);
	}

}
