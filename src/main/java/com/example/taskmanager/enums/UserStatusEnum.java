package com.example.taskmanager.enums;

public enum UserStatusEnum {

    ACTIVE(1, "Active user"),
    INACTIVE(0, "Inactive user"),
    SUSPENDED(2, "Suspended user"),
    PENDING(3, "Pending approval");

    private final int code;
    private final String description;

    UserStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static UserStatusEnum fromCode(int code) {
        for (UserStatusEnum status : UserStatusEnum.values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid UserStatus code: " + code);
    }
}
