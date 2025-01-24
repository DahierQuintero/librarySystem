package com.test.librarySystem.utils;

import lombok.Getter;

@Getter
public enum Status {
    AVAILABLE("Disponible"),
    BORROWED("Prestado");

    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    public static Status stringToEnum(String statusName) {
        for (Status status : Status.values()) {
            if (status.getStatusName().equalsIgnoreCase(statusName)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant with statusName " + statusName);
    }
}
