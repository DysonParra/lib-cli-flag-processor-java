/*
 * @fileoverview {Flag} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {Flag} fue realizada el 31/07/2022.
 * @Dev - La primera version de {Flag} fue escrita por Dyson A. Parra T.
 */
package com.project.dev.flag.processor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Definición de {@code Flag}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Flag {

    /* Nombre de la flag */
    private String name;
    /* Valor de la flag */
    private String value;
    /* Si es una flag requerida */
    private boolean required;

    /**
     * Obtiene el valor en {String} del objeto actual.
     *
     * @return un {String} con la representación del objeto.
     */
    @Override
    public String toString() {
        String result = "";
        if (required)
            result += "*";
        else
            result += " ";

        if (value == null)
            result += name;
        else
            result += name + " = " + value;

        return result;
    }

}
