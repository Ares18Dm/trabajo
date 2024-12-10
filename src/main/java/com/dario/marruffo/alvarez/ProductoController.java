package com.dario.marruffo.alvarez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    public List<Producto> productos = new ArrayList<>(
        Arrays.asList(new Producto(123,"cocacola",10.000,2))
    );

    @GetMapping("")
    public List<Producto> getproductos(){
        return productos;
    }

    @PostMapping("/agregar")
    public Producto postproductos(@RequestBody Producto producto){
        productos.add(producto);
        return producto;
    }

    @PutMapping("/editar")
    public Producto putproductos(@RequestBody Producto producto){
        for (Producto p : productos){
            if(p.getCantidadProducto() == producto.getIdProducto()){
            p.setNombre(producto.getNombre());
            p.setPrecioProducto(producto.getPrecioProducto());
            p.setCantidadProducto(producto.getCantidadProducto());
            return p;
        }
    }
    return null;
}

    @DeleteMapping("/eliminar")
    public Producto deleteprodcutos(@PathVariable Integer IdProducto){
        for(Producto p : productos){
            if (p.getIdProducto() == IdProducto){
                productos.remove(p);
                return p;
            }
        }
        return null;
    }


}
