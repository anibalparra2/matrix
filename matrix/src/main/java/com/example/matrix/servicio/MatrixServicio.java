package com.example.matrix.servicio;

import com.example.matrix.controlador.MatrixControlador;
import com.example.matrix.repositorio.Respuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatrixServicio implements IMatrixServicio{

    private static final Logger logger = LoggerFactory.getLogger(MatrixControlador.class);

    @Override
    public Respuesta search(char[][] matrix, String word) {

        List<String> horizontales = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            String cadena = "";
            for (int j = 0; j < matrix[0].length; j++) {
                cadena = cadena + matrix[i][j];
            }
            horizontales.add(cadena);
        }
        List<String> verticales = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            String cadena = "";
            for (int j = 0; j < matrix.length; j++) {
                cadena = cadena + matrix[j][i];
            }
            verticales.add(cadena);
        }
        Respuesta respuesta = new Respuesta();
        for(String text: horizontales){
            if(text.contains(word)){
                respuesta.setContains(true);
            }
        }
        for(String text: verticales){
            if(text.contains(word)){
                respuesta.setContains(true);
            }
        }

        return respuesta;
    }
}
