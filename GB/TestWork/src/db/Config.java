package db;

import db.*;

public class Config {
    private String pathRegistry;

    public Config() {

        // путь к файлу с реестром
        this.pathRegistry = "src/db/registry.csv";
    }

    public String getPathRegistry() {
        return pathRegistry;
    }
}