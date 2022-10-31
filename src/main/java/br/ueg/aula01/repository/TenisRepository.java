package br.ueg.aula01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ueg.aula01.model.Tenis;

@Repository
public interface TenisRepository extends JpaRepository<Tenis,Long> {

    List<Tenis> findByTamanho(Integer Tamanho);
	

}
