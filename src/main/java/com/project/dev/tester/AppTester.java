/*
 * @fileoverview    {AppTester}
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
package com.project.dev.tester;

import com.project.dev.flag.processor.Flag;
import com.project.dev.flag.processor.FlagProcessor;

/**
 * TODO: Description of {@code AppTester}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public class AppTester {

    /**
     * Ejecuta las pruebas de la aplicación.
     *
     * @param args argumentos de la linea de comandos.
     * @return {@code true} si se ejecutan las pruebas correctamente, {@code false} caso contrario.
     */
    public static boolean startTesting(String[] args) {
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

        Flag[] flags = FlagProcessor.convertArgsToFlags(args, defaultArgs, requiredFlags, optionalFlags, true);
        if (flags != null)
            System.out.println("Flags success processed");

        return flags != null;
    }

}
