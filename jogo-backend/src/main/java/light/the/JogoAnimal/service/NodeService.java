package light.the.JogoAnimal.service;

import light.the.JogoAnimal.domain.Node;
import light.the.JogoAnimal.repository.NodeRepository;
import light.the.JogoAnimal.utils.EnumNodeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NodeService {
    private final NodeRepository nodeRepository;

    public Node findNodeByID(Long id) {
        return nodeRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Node getRootNode(){
        return nodeRepository.getRootNode();
    }

    public Node getNext(Long currentId, Boolean isYes) {
        Node current = findNodeByID(currentId);
        if(Boolean.TRUE.equals(isYes)){
            return findNodeByID(current.getYesNode().getId());
        }
            return findNodeByID(current.getNoNode().getId());
    }

    public Node AddParent(Node current, Node newChild){
        Node parent = new Node();
        parent.setType(EnumNodeType.REGRA);
        parent.setDescription("regra teste");
        parent.setYesNode(newChild);
        parent.setNoNode(current);
        return parent; //TODO: Persistencia
    }
}
