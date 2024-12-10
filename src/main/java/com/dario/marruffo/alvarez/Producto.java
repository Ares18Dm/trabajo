package com.dario.marruffo.alvarez;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Producto {
    private Integer IdProducto;
    private String Nombre;
    private Double PrecioProducto;
    private Integer CantidadProducto;
    
}
