package com.charity_hub.shared.domain.model;

public enum Permission {
    FULL_ACCESS,
    VIEW,
    CREATE_CASES;

    /**
     * Creates a Permission from its string representation.
     *
     * @param permission the string representation of the permission
     * @return the corresponding Permission enum value
     * @throws IllegalArgumentException if the string doesn't match any Permission value
     */
    public static Permission fromString(String permission) {
        return valueOf(permission);
    }
}