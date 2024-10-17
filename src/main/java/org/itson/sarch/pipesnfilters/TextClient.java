/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.sarch.pipesnfilters;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TextClient {
    public static void main(String[] args) {
        try {
            // Conectar al servidor en localhost y puerto 8080
            Socket socket = new Socket("localhost", 8080);

            // Enviar texto al servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //Escribir el texto al servidor
            Scanner ky = new Scanner(System.in);
            String textToSend = ky.nextLine();
            System.out.println("Enviando texto: " + textToSend);
            out.println(textToSend);

            // Recibir el texto procesado del servidor
            String processedText = in.readLine();
            System.out.println("Texto procesado recibido: " + processedText);

            // Cerrar recursos
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

