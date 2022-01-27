package light.the.JogoAnimal.service;

import light.the.JogoAnimal.domain.Node;
import light.the.JogoAnimal.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NodeService {
    private final NodeRepository nodeRepository;

    /**
     * Busca Nó específico por ID
     *
     * @param id ID do nó a ser buscado
     * @return Node referente ao ID especificado
     */
    public Node findNodeByID(Long id) {
        return nodeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    /**
     * Retorna o nó na raiz, o primeiro do jogo
     * @return Node na raiz da árvore
     */
    public Node getRootNode(){
        return nodeRepository.getRootNode();
    }

    /**
     * Busca o próximo nó na árvore de classificação conforme o caminho (sim, não)
     *
     * @param currentId ID do nó atual na árvore
     * @param isYes Especifica se o caminho seguinte é sim
     * @return Node correspondente ao caminho selecionado.
     */
    public Node getNext(Long currentId, Boolean isYes) {
        Node current = findNodeByID(currentId);
        if(Boolean.TRUE.equals(isYes)){
            return findNodeByID(current.getYesNode().getId());
        }
            return findNodeByID(current.getNoNode().getId());
    }

    /**
     * Salva o nó no armazenamento (baco de dados)
     * @param newNode nó a ser criado ou atualizado
     * @return o nó escrito no banco de dados.
     */
    public Node persistNode(Node newNode){
        return nodeRepository.save(newNode);
    }

}
