/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.sarch.pipesnfilters;

import java.io.*;
import java.net.*;

public class TextServer {
    public static void main(String[] args) {
        try {
            // Crear servidor en el puerto 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Servidor escuchando en el puerto 8080...");

            while (true) {
                // Aceptar conexión de un cliente
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado...");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Leer texto enviado por el cliente
                String inputText = in.readLine();
                System.out.println("Texto recibido: " + inputText);

                // Aplicar los filtros en secuencia
                String filteredText = applyFilters(inputText);

                // Enviar el texto procesado de vuelta al cliente
                out.println(filteredText);

                // Cerrar conexión con el cliente
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para aplicar los filtros
    private static String applyFilters(String input) {
        String result = input;
        result = toUpperCaseFilter(result);
        result = removeSpacesFilter(result);
        result = addSuffixFilter(result);
        return result;
    }

    // Filtros individuales
    private static String toUpperCaseFilter(String input) {
        return input.toUpperCase();
    }

    private static String removeSpacesFilter(String input) {
        return input.replaceAll(" ", "");
    }

    private static String addSuffixFilter(String input) {
        return input + "_PROCESADO";
    }
}

