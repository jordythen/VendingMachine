package com.revature.beans.user;

public enum Status {
	CREATED,
	ACCEPTED,
	DENIED,
	FAILED;
	
	public static Status fromInt(int i) {
        return i >= 0 && i < values().length ? values()[i] : CREATED;
    }
}
