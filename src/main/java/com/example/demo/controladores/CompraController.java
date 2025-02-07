package com.example.demo.controladores;

import com.example.demo.modelos.Compra;
import com.example.demo.modelos.DetalleCompra;
import com.example.demo.modelos.Producto;
import com.example.demo.repositorios.CompraRepository;
import com.example.demo.repositorios.DetalleCompraRepository;
import com.example.demo.repositorios.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@CrossOrigin(origins = "*")
public class CompraController {

    private final CompraRepository compraRepository;
    private final DetalleCompraRepository detalleCompraRepository;
    private final ProductoRepository productoRepository;

    public CompraController(CompraRepository compraRepository, DetalleCompraRepository detalleCompraRepository, ProductoRepository productoRepository) {
        this.compraRepository = compraRepository;
        this.detalleCompraRepository = detalleCompraRepository;
        this.productoRepository = productoRepository;
    }

    // Obtener todas las compras
    @GetMapping
    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    // Crear una nueva compra con detalles
    @PostMapping
    public Compra createCompra(@RequestBody Compra compra) {
        return compraRepository.save(compra);
    }

    // Agregar un producto a una compra existente
    @PostMapping("/{idCompra}/agregar-producto/{idProducto}/{cantidad}")
    public DetalleCompra agregarProductoACompra(@PathVariable int idCompra, @PathVariable int idProducto, @PathVariable int cantidad) {
        Compra compra = compraRepository.findById(idCompra).orElseThrow();
        Producto producto = productoRepository.findById(idProducto).orElseThrow();

        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setCompra(compra);
        detalleCompra.setProducto(producto);
        detalleCompra.setCantidad(cantidad);
        detalleCompra.setPrecioUnitario(producto.getPrecio());

        return detalleCompraRepository.save(detalleCompra);
    }
}
