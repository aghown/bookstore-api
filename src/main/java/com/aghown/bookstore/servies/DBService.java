package com.aghown.bookstore.servies;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aghown.bookstore.domain.Categoria;
import com.aghown.bookstore.domain.Livro;
import com.aghown.bookstore.repositories.CategoriaRepository;
import com.aghown.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Distopia", "Livros Distopicos");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Análise de Tráfego em Redes TCP/IP", "João Eriberto Mota Filho", "Lorem ipsum",
				cat1);
		Livro l3 = new Livro(null, "1984", "George Orwell", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "Divergente", "Veronica Roth", "Lorem ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));

	}

}
