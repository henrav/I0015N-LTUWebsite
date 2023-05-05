package com.example.i0015nltuwebsite.Config;

import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ConfigConfig {

    private static final String CONFIG_FILE = "F:\\CodingSpaces\\intellij-workspace\\I0015N-LTUWebsite\\src\\LTUcredentials.json";


        public static String getEmail(String key) {
            // get the email to login with
            System.out.println("running code");
            File jsonFile = new File(CONFIG_FILE);

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
        public static String getPassword(String key) {
            // get the password to login with
            System.out.println("running code");
            File jsonFile = new File(CONFIG_FILE);

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
            }return null;
        }
        public static String getSchoolSearch(String key){
            System.out.println("running code");
            File jsonFile = new File(CONFIG_FILE);

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
            }return null;
        }
    }

