package com.example.matrix.servicio;

import com.example.matrix.repositorio.Respuesta;

public interface IMatrixServicio {

    Respuesta search(char[][] matrix, String word);

}
