package light.the.JogoAnimal.repository;

import light.the.JogoAnimal.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {

    //Existe uma forma melhor de buscar a raiz de uma árvore, mas funciona pra esse caso em específico
    @Query("select n from Node n where n.description = 'vive na água'")
    Node getRootNode();
}
