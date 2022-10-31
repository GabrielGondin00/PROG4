package br.ueg.aula01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.aula01.model.Tenis;
import br.ueg.aula01.service.TenisService;

@RestController
@RequestMapping(path = "api/v1/tenis")
public class Teniscontroller {
  

	@Autowired
	private TenisService tenisService;
	
	@GetMapping()
	public List<Tenis> listarTodos(){
		return  tenisService.listar();
	}
	
	@GetMapping( path = "{idTenis}")
	public Tenis getTenis(@PathVariable("idTenis") Long idTenis) {
		return  tenisService.getTenis(idTenis);
	}
	
	@GetMapping( path ="tamanho/{tamanho}")
	public List<Tenis> getTenisByTamanho(@PathVariable("tamanho") Integer tamanho){
		return  tenisService.getTenisByTamanho(tamanho);
	}
	
	@PostMapping
	public Tenis incluir(@RequestBody Tenis tenis) {
		return  tenisService.incluir(tenis);
	}
	
	@DeleteMapping( path = "{idTenis}")
	public Tenis remover(@PathVariable("idTenis") Long idTenis) {
		return  tenisService.remover(idTenis);
	}
	
	@PatchMapping( path = "{idTenis}")
	public 	Tenis alterar(@RequestBody Tenis tenis, @PathVariable("idTenis") Long idTenis) {
		return  tenisService.alterar(tenis, idTenis);
	}
	}
