package com.revature.beans.user;

public enum Status {
	CREATED, //0
	ACCEPTED, //1
	DENIED, //2
	FAILED; //3
	
	public static Status fromInt(int i) {
        return i >= 0 && i < values().length ? values()[i] : CREATED;
    }
}
