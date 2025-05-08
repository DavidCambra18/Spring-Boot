package com.cebem.medidor.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<Type> types;
    private Sprites sprites;
    private List<Stat> stats;
    private String species;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Type {
        private int slot;
        private TypeInfo type;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TypeInfo {
            private String name;
            private String url;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sprites {
        private String frontDefault;
        private Other other;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Other {
            private OfficialArtwork officialArtwork;

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class OfficialArtwork {
                private String frontDefault;
            }
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Stat {
        private int baseStat;
        private int effort;
        private StatInfo stat;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class StatInfo {
            private String name;
            private String url;
        }
    }
}