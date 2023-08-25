package com.example.matrix.controlador;

import com.example.matrix.repositorio.DataIn;
import com.example.matrix.repositorio.ForbiddenException;
import com.example.matrix.repositorio.Respuesta;
import com.example.matrix.servicio.MatrixServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("matrix")
public class MatrixControlador {

    private static final Logger logger = LoggerFactory.getLogger(MatrixControlador.class);
    @Autowired
    private MatrixServicio matrixServicio;

    @PostMapping("/search-horandvert")
    public Respuesta search(@RequestBody DataIn dataIn) throws ForbiddenException {
        logger.info("dataIn: "+ dataIn);
        String searchword = dataIn.getSearchword();
        int rows = dataIn.getRows();
        String word = dataIn.getWord();
        double searchwordSize = searchword.length();
        if(rows > 0){
            double columns = searchwordSize / rows;
            logger.info("filas: "+rows);
            logger.info("columnas: "+columns);
            int iPart = (int)columns;
            double fPart = columns - iPart;
            if(fPart > 0){
                throw new ForbiddenException("403-Forbidden");
            }else{
                char searchwordMatrix[][] =  new char[rows][(int)columns];
                System.out.println("matrix: ");
                int index = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < (int)columns; j++) {
                        searchwordMatrix[i][j] = searchword.charAt(index);
                        index++;
                        System.out.print(searchwordMatrix[i][j]);
                    }
                    System.out.println("");
                }
                Respuesta respuesta = this.matrixServicio.search(searchwordMatrix,word);
                respuesta.setRows(rows);
                respuesta.setSearchword(searchword);
                respuesta.setWord(word);
                return respuesta;
            }
        }else{
            throw new ForbiddenException("403-Forbidden");
        }
    }

}
