package com.revature.beans.snack;


public enum Size {

	SMALL,
	MEDIUM,
	LARGE,
	X_LARGE,
	JUMBO;
	;
	
	public static Size fromInt(int i) {
        return i >= 0 && i < values().length ? values()[i] : MEDIUM;
    }
}
