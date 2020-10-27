package br.com.fiap.apialunos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.apialunos.model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
	
	public List<Aluno> findByNome(String nome);

	public List<Aluno> findByNomeLike(String nome);

//	@Query("{ 'idade' : ?0 }")
	public List<Aluno> findByIdade(int idade);
	
}
