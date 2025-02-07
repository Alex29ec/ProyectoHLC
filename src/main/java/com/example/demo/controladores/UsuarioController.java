package com.example.demo.controladores;

import com.example.demo.modelos.LoginDTO;
import com.example.demo.modelos.Usuario;
import com.example.demo.modelos.UsuarioDTO;
import com.example.demo.repositorios.UsuarioRepository;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

      
        @PostMapping("/login")
        public ResponseEntity<UsuarioDTO> login(@RequestBody LoginDTO loginDTO) {
            // Buscar al usuario por el email
            Optional<Usuario> usuario = usuarioRepository.findByEmail(loginDTO.getEmail());
            
            if (usuario.isPresent()) {
                // Comparar las contraseñas (esto es en texto plano por ahora)
                if (usuario.get().getPassword().equals(loginDTO.getPassword())) {
                    // Si la contraseña coincide, devolver los datos del usuario (ejemplo: nombre)
                    UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.get().getId(), usuario.get().getNombre(), usuario.get().getEmail());
                    return ResponseEntity.ok(usuarioDTO);
                } else {
                    // Si las contraseñas no coinciden
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
                }
            }
            
            // Si no se encuentra el usuario
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    
        
        

    // Método para el registro
    @PostMapping("/registro")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        // Verificar si el email ya está registrado
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El email ya está registrado");
        }

        // Si el email no está registrado, guardar el nuevo usuario
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
    }
}
