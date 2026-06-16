package example;

import java.util.Locale;

public class NormalStatus {
    public static void main(String[] args) {
        System.out.println(setMessageForStatus("  in_progresss "));

    }


    static String setMessageForStatus(String status) {
        String normalizedStatus = normalizeStatus(status);
        return switch (normalizedStatus) {
            case "OPEN" -> "status is open";
            case "CLOSED" -> "status is closed";
            case "IN_PROGRESS" -> "status in progress";
            default -> "invalid status given";

        };
    }

    static String normalizeStatus(String status) {
        if (status == null || status.isBlank()) {
            return "INVALID_STATUS";
        }

        String normalized = status.trim().toUpperCase(Locale.ROOT);

        return normalized;
    }

    static boolean canAssignTicket(String status, boolean userActive, String role) {
        if (!userActive) {
            System.out.println("only active users can assign ticket");
            return false;
        }

        if (status == null || status.equals("ASSIGNED") || status.equals("CLOSED")) {
            System.out.println("status is invalid");
            return false;
        }

        if ("USER".equals(role)) {

            return false;
        }

        return true;
    }


}
