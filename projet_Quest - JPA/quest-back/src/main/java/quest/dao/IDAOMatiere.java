package quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Matiere;

public interface IDAOMatiere extends JpaRepository<Matiere,Integer> {

	@Query("Select m from Matiere m where m.quest=:quest")
	public Matiere findByCode(@Param("quest") int quest);
	
	public Matiere findByQuest(int quest);
}
