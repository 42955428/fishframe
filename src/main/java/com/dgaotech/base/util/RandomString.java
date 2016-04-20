package com.dgaotech.base.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

public class RandomString {
	
	/***基础字符集***/
	
	public static enum SeedSet {
		LOWER_LETTER,
		UPPER_LETTER,
		NUMBER
	}
		
	private final static int[] LOWER_LETTER = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	private final static int[] UPPER_LETTER = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	private final static int[] NUMBER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	private static Map<String, int[]> SEED_SET_MAP = new HashMap<String, int[]>();
	
	static {
		SEED_SET_MAP.put(SeedSet.LOWER_LETTER.toString(), LOWER_LETTER);
		SEED_SET_MAP.put(SeedSet.UPPER_LETTER.toString(), UPPER_LETTER);
		SEED_SET_MAP.put(SeedSet.NUMBER.toString(), NUMBER);
	}
	
	/***基础字符集***/
	
	private static Logger log = Logger.getLogger(RandomString.class);
	
	/**
	 * 
	 * @datetime ：2009-5-25 下午04:25:37
	 * @author ：JasonFeng
	 * @功能 ：生成指定长度的随机字符串，使用指定的基础字符集。
	 * 		   getRandomString(10)或者getRandomString(10, null)默认使用所有的基础字符集
	 * @param len
	 * @param seedSet
	 * @return
	 */
	public static String getRandomString(int len, SeedSet... seedSet) {
		int i; // 生成的随机数
		char[] seed = prepareSeed(seedSet);
		int maxNum = seed == null ? 0 : seed.length;
		StringBuffer pwd = new StringBuffer();
		Random r = new Random();
		for (int j = 0; j < len; j++) {
			i = Math.abs(r.nextInt(maxNum));
			if (i >= 0 && i < seed.length) {
				pwd.append(seed[i]);
			}
		}
		return pwd.toString();
	}
	
	/**
	 * 
	 * @datetime ：2009-5-25 下午02:52:52
	 * @author ：JasonFeng
	 * @功能 ：准备随机字符串字符集，将多个基础字符集合成一个，并合并相同字符集
	 * 		   如果未指定任何基础字符集，则使用所有的基础字符集
	 * @param seedSet
	 * @return
	 */
	public static char[] prepareSeed(SeedSet... seedSet) {
		char[] seeds = null;
		if (seedSet.length == 0) {
			seedSet = SeedSet.values();
		}
		Set tmpSeedSet = new HashSet();
		for (int i = 0; i < seedSet.length; i++) {
			int[] tmpBaseSeed = SEED_SET_MAP.get(seedSet[i].toString());
			for (int c : tmpBaseSeed) {
				tmpSeedSet.add(c);
			}
		}
		if (tmpSeedSet.size() > 0) {
			int index = 0;
			seeds = new char[tmpSeedSet.size()];
			Iterator usedSeedIte = tmpSeedSet.iterator();
			try {
				while (usedSeedIte.hasNext()) {
					seeds[index++] = (char) Integer.parseInt(String
							.valueOf(usedSeedIte.next()));
				}
			} catch (NumberFormatException e) {
				log.error("Error when prepared seed.", e);
				seeds = null;
			} catch (Exception e) {
				log.error("Unknown Error.", e);
				seeds = null;
			}
		}
		return seeds;
	}
	
	public static void main(String[] args) {
		//System.out.println(getRandomString(10, SeedSet.NUMBER));
	}
}
