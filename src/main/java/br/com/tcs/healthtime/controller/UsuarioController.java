package br.com.tcs.healthtime.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.tcs.healthtime.dao.UsuarioDAO;
import br.com.tcs.healthtime.dto.Cpf;
import br.com.tcs.healthtime.i18n.Messages;
import br.com.tcs.healthtime.i18n.MessagesProperties;
import br.com.tcs.healthtime.model.Usuario;
import br.com.tcs.healthtime.rest.ApiResponse;
import br.com.tcs.healthtime.rest.ResponseEntityUtil;

@RestController
@CrossOrigin
public class UsuarioController {

	@Autowired
	Messages message;

	@Autowired
	UsuarioDAO dao;

	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	@PostMapping(value = "/salvar", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ApiResponse> saveUser(@RequestBody Usuario usuario) {
		Usuario novoUsuario = null;
		try {
			Usuario usuarioNovo = usuario;
			if (usuario == null) {
				return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
						usuario);
			} else {
				if (usuarioNovo.getNome().equalsIgnoreCase("") || usuarioNovo.getCpf().equals("")) {
					return ResponseEntityUtil.notFoundResponseEntity(message.get(MessagesProperties.API_UNKNOWN_FIELDS),
							usuario);
				} else {
					novoUsuario = dao.saveUser(usuario);
					if (novoUsuario != null) {
						return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.CLI_SUCESS),
								novoUsuario);
					} else {
						return ResponseEntityUtil.unprocessableResponseEntity(
								message.get(MessagesProperties.API_UNKNOWN_FIELDS), usuario);
					}
				}
			}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
					usuario);
		}

	}
	
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	@PostMapping(value = "/verificaUser", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ApiResponse> verificaUser(@RequestBody String json) {
		Usuario usuario = null;
		System.out.println("Iniciando gson... "+ json);
		JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);
		System.out.println( convertedObject.get("cpf").getAsString());
		String cpfParam = convertedObject.get("cpf").getAsString();//cpf.replaceAll("{", "").replaceAll("}", "").replaceAll("\n", "").replaceAll("\"", "").trim();
		try {
			String cpf = cpfParam;
			System.out.println("cpfParam"+cpfParam);
			System.out.println("cpf"+cpf);
			if (cpfParam.isEmpty()) {
				return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
						cpfParam);
			} else {
				if (cpfParam.isEmpty()) {
					return ResponseEntityUtil.notFoundResponseEntity(message.get(MessagesProperties.API_UNKNOWN_FIELDS),
							cpf);
				} else {
					usuario = dao.findByCpf(cpfParam);
					System.out.println(usuario);
					if (usuario != null) {
						return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.CLI_SUCESS),
								usuario);
					} else {
						return ResponseEntityUtil.unprocessableResponseEntity(
								message.get(MessagesProperties.API_UNKNOWN_FIELDS), usuario);
					}
				}
			}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
					"Exception "+cpfParam);
		}

	}
	
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	@PatchMapping(value = "/updateUser", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ApiResponse> updateUser(@RequestBody @Validated Usuario usuario) {
		try {
			Usuario updateUsuario = usuario;
			if (usuario == null) {
				return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
						usuario);
			} else {
				if (updateUsuario.getNome().equalsIgnoreCase("") || updateUsuario.getCpf().equals("")) {
					return ResponseEntityUtil.notFoundResponseEntity(message.get(MessagesProperties.API_UNKNOWN_FIELDS),
							usuario);
				} else {
					updateUsuario = dao.saveUser(usuario);
					if (updateUsuario != null) {
						return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.CLI_UPDATED));
					} else {
						return ResponseEntityUtil.unprocessableResponseEntity(
								message.get(MessagesProperties.API_UNKNOWN_FIELDS), usuario);
					}
				}
			}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
					usuario);
		}

	}

	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping(value = "/lista_usuario", produces = "application/json")
	public ResponseEntity<ApiResponse> listUsers() {
		java.util.List<Usuario> usuarios = null;
		try {

			usuarios = dao.listAll();

			if (usuarios != null) {
				return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.API_SUCESS), usuarios);
			} else {
				return ResponseEntityUtil
						.unprocessableResponseEntity(message.get(MessagesProperties.CLI_NOT_FOUND), usuarios);
			}

		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.API_ERROR), usuarios);
		}

	}
	
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping(value = "/findById", produces = "application/json")
	public ResponseEntity<ApiResponse> findById(@RequestParam("id") Long id) {
		Usuario usuario = null;
		try {

			usuario = dao.findById(id);

			if (usuario != null) {
				return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.API_SUCESS), usuario);
			} else {
				return ResponseEntityUtil
						.unprocessableResponseEntity(message.get(MessagesProperties.CLI_NOT_FOUND), usuario);
			}

		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.API_ERROR), usuario);
		}

	}
	
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	@DeleteMapping(value = "/delete", produces = "application/json")
	public ResponseEntity<ApiResponse> delete(@RequestParam("id") Long id) {
		boolean resultado = false;
		try {

			if (resultado = dao.delete(id) == true) {
				return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.API_SUCESS));
			} else {
				return ResponseEntityUtil
						.unprocessableResponseEntity(message.get(MessagesProperties.CLI_NOT_FOUND), null);
			}

		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.API_ERROR), null);
		}

	}
	
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping(value = "/findByName", produces = "application/json")
	public ResponseEntity<ApiResponse> findByName(@RequestParam("nome") String nome) {
		List<Usuario> usuario = null;
		try {

			usuario = dao.findByName(nome);

			if (usuario != null) {
				return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.API_SUCESS), usuario);
			} else {
				return ResponseEntityUtil
						.unprocessableResponseEntity(message.get(MessagesProperties.CLI_NOT_FOUND), usuario);
			}

		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.API_ERROR), usuario);
		}

	}

}
