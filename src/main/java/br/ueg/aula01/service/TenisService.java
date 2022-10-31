package br.ueg.aula01.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import br.ueg.aula01.model.Tenis;
import br.ueg.aula01.repository.TenisRepository;



@Service
public class TenisService {
	
	@Autowired
	private TenisRepository tenisRepository;
	
	public Tenis incluir(Tenis tenis) {
		
		Tenis tenisRetorno = tenisRepository.save(tenis);
		return tenisRetorno;
}
	
	public List<Tenis> listar(){
		return tenisRepository.findAll();
	}
	
	public Tenis getTenis(Long idTenis) {
		Optional<Tenis> Tenis = obterTenisSeExiste(idTenis);
		
		return Tenis.get();
	}

	private Optional<Tenis> obterTenisSeExiste(Long idTenis) {
		Optional<Tenis> Tenis = tenisRepository.findById(idTenis);
		
		if(!Tenis.isPresent()) {
			throw new IllegalStateException("Não existe Tenis com o ID:"+idTenis);
		}
		return Tenis;
	}
	
	public List<Tenis> getTenisByTamanho(Integer tamanho){
		List<Tenis> Tenis = tenisRepository.findByTamanho(tamanho);
		if(CollectionUtils.isEmpty(Tenis)) {
			throw new IllegalAccessError("Nenhum Tenis com a tamanho: "+tamanho+" encontrado");
		}
		return Tenis;
	}

	public Tenis remover(Long idTenis) {
		Optional<Tenis> TenisOptional = obterTenisSeExiste(idTenis);
		Tenis Tenis = TenisOptional.get();
		tenisRepository.delete(Tenis);		
		return Tenis;
	}

	public Tenis alterar(Tenis tenis, Long idTenis) {
		Optional<Tenis> TenisOptional = obterTenisSeExiste(idTenis);
		Tenis TenisBD = TenisOptional.get();
		
		if(StringUtils.hasLength(tenis.getModelo())) {
			TenisBD.setModelo(tenis.getModelo());
		}
		
		if(StringUtils.hasLength(tenis.getMarca())) {
			TenisBD.setMarca(tenis.getMarca());
		}
		
		if(tenis.getTamanho() != null) {
			TenisBD.setTamanho(tenis.getTamanho());
		}
		
		TenisBD = tenisRepository.save(TenisBD);
				
		return TenisBD;
	}

	



}


