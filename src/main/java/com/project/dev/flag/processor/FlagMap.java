/*
 * @fileoverview {FlagMap}, se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @history v1.0 --- La implementacion de {FlagMap} fue realizada el 30/09/2022.
 * @dev - La primera version de {FlagMap} fue escrita por Dyson A. Parra T.
 */
package com.project.dev.flag.processor;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Definición de {@code FlagMap}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class FlagMap {

    /**
     * TODO: Definición de {@code convertFlagsArrayToMap}.
     *
     * @param flags
     * @return
     */
    public static Map<String, String> convertFlagsArrayToMap(Flag[] flags) {
        Map<String, String> flagsMap = new HashMap<>();
        for (Flag aux : flags)
            flagsMap.put(aux.getName(), aux.getValue() == null ? "" : aux.getValue());
        return flagsMap;
    }

    /**
     * TODO: Definición de {@code validateFlagInMap}.
     *
     * @param <T>
     * @param flagsMap
     * @param flagName
     * @param defaultValue
     * @param classType
     * @return
     */
    public static <T> T validateFlagInMap(Map<String, String> flagsMap,
            String flagName, T defaultValue, Class<T> classType) {
        boolean validFlag = false;
        T resultValue = null;
        String flagValue = flagsMap.get(flagName);
        if (flagValue != null) {
            try {
                resultValue = classType.getConstructor(String.class).newInstance(flagValue);
                validFlag = true;
            } catch (Exception e) {
                System.out.printf("Invalid value '%s' for flag '%s'.\n", flagValue, flagName);
                //e.printStackTrace(System.out);
            }
        }
        if (!validFlag) {
            try {
                resultValue = defaultValue;
                String defaultFlag = String.valueOf(defaultValue);
                System.out.printf("Using default value '%s' in flag '%s'.\n", defaultFlag, flagName);
                flagsMap.put(flagName, defaultFlag);
            } catch (Exception e) {
                //e.printStackTrace(System.out);
            }
        }
        return resultValue;
    }
}
