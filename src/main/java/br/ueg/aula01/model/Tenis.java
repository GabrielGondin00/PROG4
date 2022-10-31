package br.ueg.aula01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TBL_TENIS")
public @Data class Tenis {
   
   @Id
   @SequenceGenerator(
		name = "tenis_sequence",
		sequenceName = "tenis_sequence",
		allocationSize = 1,
		initialValue = 1
		 )
   @GeneratedValue(
		   strategy = GenerationType.SEQUENCE ,
		   generator = "tenis_sequence"  )
   
	private Long id;
   
   @Column(name = "modelo", nullable = false,	length = 200)
   private String modelo;
   
   @Column(name = "marca", nullable = false, length = 150)
   private String marca;
   
   @Column(name = "tamanho", nullable = false)
   private Integer tamanho;
   
   @Column(name = "preco", nullable = false, length = 250)
   private String preco;

}
