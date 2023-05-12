package com.example.i0015nltuwebsite.Config;

import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Config {

    private static String PATH = "C:\\temp\\ltu.json";

    public static String getEmail(String key) {
        // get the email to login with
        File jsonFile = new File(PATH);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            JsonNode credentialsNode = jsonNode.get("ltuCredentials");

            Iterator<String> fieldNames = credentialsNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if (fieldName.equalsIgnoreCase(key)) {
                    return credentialsNode.get(fieldName).asText();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    // get the password to login with
    public static String getPassword(String key) {
        File jsonFile = new File(PATH);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            JsonNode credentialsNode = jsonNode.get("ltuCredentials");

            Iterator<String> fieldNames = credentialsNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if (fieldName.equalsIgnoreCase(key)) {
                    return credentialsNode.get(fieldName).asText();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String getSchoolSearch(String key) {
        return "Luleå tekniska universitet";
    }
}
