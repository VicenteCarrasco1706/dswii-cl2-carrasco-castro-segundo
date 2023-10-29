package pe.cibertec.edu.dswiicl2carrascocastrosegundo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.edu.dswiicl2carrascocastrosegundo.model.bd.Producto;
import pe.cibertec.edu.dswiicl2carrascocastrosegundo.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> producto =  productoRepository.findById(id);
        if (producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }

    public Optional<Producto> obtenerProductoPorNombre(String nombre){
        Optional<Producto> producto = productoRepository.findByNombre(nombre);
        if(producto.isEmpty())
            return Optional.empty();
        else
            return producto;
    }

    public List<Producto> obtenerPrductosPorFiltro(String filtro){
        return productoRepository.filtrarProductosPorNombre(filtro);
    }

}
