package com.cebem.medidor.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperHero {
    private String id;
    private String name;
    private Powerstats powerstats;
    private Biography biography;
    private Appearance appearance;
    private Image image;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Powerstats {
        private String intelligence;
        private String strength;
        private String speed;
        private String durability;
        private String power;
        private String combat;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Biography {
        private String fullName;
        private String alterEgos;
        private String aliases;
        private String placeOfBirth;
        private String firstAppearance;
        private String publisher;
        private String alignment;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Appearance {
        private String gender;
        private String race;
        private String height;
        private String weight;
        private String eyeColor;
        private String hairColor;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class work {
        private String occupation;
        private String base;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Connections {
        private String groupAffiliation;
        private String relatives;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Image {
        private String url;
    }
}