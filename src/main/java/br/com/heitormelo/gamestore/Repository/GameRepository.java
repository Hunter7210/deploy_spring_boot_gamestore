package br.com.heitormelo.gamestore.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.heitormelo.gamestore.Model.Game;

//Criação do repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    //Não é necessário colocar nenhum metodo
    
}
