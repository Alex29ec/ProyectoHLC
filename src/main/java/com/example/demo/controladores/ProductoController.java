package com.example.demo.controladores;

import com.example.demo.modelos.Producto;
import com.example.demo.modelos.ProductoDTO;
import com.example.demo.repositorios.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permite llamadas desde Angular
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    @GetMapping
    public List<ProductoDTO> getAllProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(p -> new ProductoDTO(p.getId(), p.getNombre(), p.getPrecio(), p.getImagen()))
                .collect(Collectors.toList());
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ProductoDTO getProductoById(@PathVariable int id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto != null ? new ProductoDTO(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getImagen()) : null;
    }

    // Guardar un nuevo producto
    @PostMapping
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO) {
        Producto producto = new Producto(productoDTO.getNombre(), productoDTO.getPrecio(), productoDTO.getImagen());
        Producto savedProducto = productoRepository.save(producto);
        return new ProductoDTO(savedProducto.getId(), savedProducto.getNombre(), savedProducto.getPrecio(), savedProducto.getImagen());
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public ProductoDTO updateProducto(@PathVariable int id, @RequestBody ProductoDTO productoDTO) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setNombre(productoDTO.getNombre());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setImagen(productoDTO.getImagen());
            Producto updatedProducto = productoRepository.save(producto);
            return new ProductoDTO(updatedProducto.getId(), updatedProducto.getNombre(), updatedProducto.getPrecio(), updatedProducto.getImagen());
        }
        return null;
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable int id) {
        productoRepository.deleteById(id);
    }
}
