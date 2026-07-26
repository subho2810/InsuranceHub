package com.insurancehub.identity.util;

import java.util.Set;

public final class SortUtils {

    private SortUtils() {
    }

    private static final Set<String> USER_SORT_FIELDS = Set.of(
            "firstName",
            "lastName",
            "email",
            "phoneNumber",
            "enabled"
    );

    public static String validateUserSortField(String sortBy) {

        if (sortBy == null || !USER_SORT_FIELDS.contains(sortBy)) {
            return "firstName";
        }

        return sortBy;
    }
}