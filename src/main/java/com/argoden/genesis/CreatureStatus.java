package com.argoden.genesis;

public enum CreatureStatus {
    ALIVE("Alive"),
    DEAD("Dead");

    public final String name;

    CreatureStatus(String name) {
        this.name = name;
    }

    public static CreatureStatus findByName(String name) {
        for(CreatureStatus status : values()) {
            if(status.name.equals(name)) {
                return status;
            }
        }

        return null;
    }
}
