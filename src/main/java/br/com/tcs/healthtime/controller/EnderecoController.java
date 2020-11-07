package br.com.tcs.healthtime.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcs.healthtime.dao.EnderecoDAO;
import br.com.tcs.healthtime.i18n.Messages;
import br.com.tcs.healthtime.i18n.MessagesProperties;
import br.com.tcs.healthtime.model.Endereco;
import br.com.tcs.healthtime.rest.ApiResponse;
import br.com.tcs.healthtime.rest.ResponseEntityUtil;

@RestController
@CrossOrigin
public class EnderecoController {
	
	@Autowired
	Messages message;

	@Autowired
	EnderecoDAO dao;
	
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	@PostMapping(value = "/salvarEndereco", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ApiResponse> saveUser(@RequestBody Endereco endereco) {
		Endereco novoEndereco = null;
		try {
			Endereco enderecoNovo = endereco;
			System.out.println(endereco);
			if (endereco == null) {
				return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
						endereco);
			} else {
				if (enderecoNovo.getBairro().equalsIgnoreCase("") || enderecoNovo.getCep().equals("")) {
					return ResponseEntityUtil.notFoundResponseEntity(message.get(MessagesProperties.API_UNKNOWN_FIELDS),
							endereco);
				} else {
					novoEndereco = dao.saveEndereco(endereco);
					if (novoEndereco != null) {
						return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.CLI_SUCESS),
								novoEndereco);
					} else {
						return ResponseEntityUtil.unprocessableResponseEntity(
								message.get(MessagesProperties.API_UNKNOWN_FIELDS), endereco);
					}
				}
			}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
					endereco);
		}

	}

}
