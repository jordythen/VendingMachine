package com.revature.beans.snack;


public enum Type {

	DRIED_FRUIT, 
	NUTS, 
	CHIPS,
	CHOCOLATE,
	CHEESE,
	CRACKERS,
	TRAIL_MIX,
	YOGURT,
	JERKY,
	CANDY,
	COOKIES,
	PRETZELS,
	FRUIT_CANDY,
	PROTEIN_BAR, 
	CEREAL_BAR,  
	OTHER;

    public static Type fromInt(int i) {
        return i >= 0 && i < values().length ? values()[i] : OTHER;
    }
}
