/*
 * @fileoverview    {FlagMap}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
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
     * Convierte un array de {@code Flag} en un {@code Map<String, String>} con las flags.
     *
     * @param flags es el array que se va a convertir en Map.
     * @return {@code Map<String, String>} con las flags.
     */
    public static Map<String, String> convertFlagsArrayToMap(Flag[] flags) {
        Map<String, String> flagsMap = new HashMap<>();
        for (Flag aux : flags)
            flagsMap.put(aux.getName(), aux.getValue() == null ? "" : aux.getValue());
        return flagsMap;
    }

    /**
     * Verifica si un {@code String} que indica una {@code Flag} está en el {@code Map} indicado por
     * {@code flagsMap}, en caso de estar en el {@code Map} verifica si es del tipo indicado por
     * {@code classType}.
     *
     * @param <T>          tipo de dato que se validará que tenga el {@code Flag} indicado por
     *                     {@code flagName}.
     * @param flagsMap     un map que contiene varios {@code Flag} como {@code String}.
     * @param flagName     el nombre del {@code Flag} que se buscará en {@code flagsMap}.
     * @param defaultValue es el valor por defecto que se retornará en caso de que el
     *                     {@code flagName} no se ecnuentre o sea de un tipo diferente al indicado
     *                     por {@code classType}.
     * @param classType    tipo de clase que se validará que tenga el {@code Flag} indicado por
     *                     {@code flagName}.
     * @return el {@code Flag} indicado por {@code flagName} convertido en el tipo indicado por
     *         {@code classType} si la flag se encuentra en {@code flagsMap} y no ocurre error al
     *         hacer la conversión a dicho tipo, caso contrario {@code defaultValue}.
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
