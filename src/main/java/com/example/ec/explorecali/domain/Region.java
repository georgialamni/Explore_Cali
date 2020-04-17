package com.example.ec.explorecali.domain;

public enum Region {

    Central_Cost("Central Cost"),
    Southern_California("Southern California"),
    Northern_California("Northern California"),
    Varies("Varies");

    private String label;

    private Region(String label) {
        this.label = label;
    }

    public static Region findByRegion(String byLabel) {
        for (Region r : Region.values()) {
            if (r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }
}
