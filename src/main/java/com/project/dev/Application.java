/*
 * @fileoverview {Application} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {Application} fue realizada el 31/07/2022.
 * @Dev - La primera version de {Application} fue escrita por Dyson A. Parra T.
 */
package com.project.dev;

import com.project.dev.flag.processor.Flag;
import com.project.dev.flag.processor.FlagProcessor;

/**
 * TODO: Definición de {@code Application}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class Application {

    /**
     * Entrada principal del sistema.
     *
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("\n...START...");

        String requiredFlags[][] = {
            {"-use", "--notUse", "--find"},
            {"-name", "--noName"},
            {"-encoder", "--noEncoder"}
        };

        String optionalFlags[][] = {
            {"-flag", "--noFlag"},
            {"-test", "--noTest"}
        };

        String defaultArgs[] = {
            "--useDefault",
            "-uses",
            "MKV",
            "-noTest",
            "aac",
            "-use",
            "ffmpeg",
            "-name",
            "chromedriver.exe",
            "-test",
            "_urls.xml",
            "--aac",
            "--noEncoder"
        };

        // for (String arg : args)
        //     System.out.println(arg);
        Flag[] flags;
        if (args.length != 0) {
            System.out.println("Validating specified flags...");
            flags = FlagProcessor.validateFlags(args, requiredFlags, optionalFlags, true);
        } else {
            System.out.println("No flags specified, validating default flags...");
            flags = FlagProcessor.validateFlags(defaultArgs, requiredFlags, optionalFlags, true);
        }
        if (flags == null) {
            System.out.println("...ERROR IN FLAGS...");
            return;
        }

        FlagProcessor.printFlagsArray(flags, true);
        System.out.println("...END...");
    }

}
