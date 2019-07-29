package com.robertodev.springsecuritycrud.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.robertodev.springsecuritycrud.event.RecursoCriadoEvent;
import com.robertodev.springsecuritycrud.model.Users;
import com.robertodev.springsecuritycrud.repository.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersResource {

	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public ResponseEntity<?> listarTodos() {
		List<Users> usuarios = userRepository.findAll();

		if (!usuarios.isEmpty()) {
			return ResponseEntity.ok(usuarios);
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{codigo}")
	public ResponseEntity<?> listarPorCodigo(@PathVariable Long codigo) {
		Optional<Users> usuario = userRepository.findById(codigo);

		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> listarPorNome(@PathVariable String nome) {
		List<Users> usuarios = userRepository.findByNomeIgnoreCaseContaining(nome);

		if (!usuarios.isEmpty()) {
			return ResponseEntity.ok(usuarios);
		}
		return ResponseEntity.noContent().build();
	}
	

	@PostMapping
	public ResponseEntity<Users> criar(@Valid @RequestBody Users usuario, HttpServletResponse resp) {
		Users usuarioSalvo = userRepository.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, resp, usuarioSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@DeleteMapping("{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		userRepository.deleteById(codigo);
	}

}
