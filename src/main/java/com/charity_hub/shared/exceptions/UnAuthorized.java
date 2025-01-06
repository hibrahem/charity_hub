package com.charity_hub.shared.exceptions;

public class UnAuthorized extends RuntimeException {
    public UnAuthorized(String description) {
        super("Unauthorized: " + (description != null ? description : ""));
    }

    public UnAuthorized() {
        super("Unauthorized");
    }

}
