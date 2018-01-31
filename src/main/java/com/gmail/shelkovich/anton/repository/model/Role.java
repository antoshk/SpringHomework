package com.gmail.shelkovich.anton.repository.model;

public enum Role {
    ROLE_USER {
        @Override
        public String toString() {
            return "User";
        }
    },
    ROLE_ADMIN {
        @Override
        public String toString() {
            return "Administrator";
        }
    }
}
