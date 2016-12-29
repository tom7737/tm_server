package com.bjgt.ms.util;

import java.util.Comparator;

public class Mymap implements Comparator<Mymap> {

	private String key;
	private int value;

	public Mymap(String key, int value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Mymap() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return key + "------" + value ;
	}

	@Override
	public int compare(Mymap arg0, Mymap arg1) {
		return arg1.value - arg0.value;
	}

}