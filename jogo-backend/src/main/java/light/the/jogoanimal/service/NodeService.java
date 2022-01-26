package light.the.jogoanimal.service;

import light.the.jogoanimal.domain.Node;
import light.the.jogoanimal.repository.NodeRepository;
import light.the.jogoanimal.utils.EnumNodeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NodeService {
    private final NodeRepository nodeRepository;

    public Node getNodeByID(Long id) throws Exception{
        return nodeRepository.findById(id).orElseThrow(Exception::new);
    }

    public Node getNext(Node current, Boolean isYes) throws Exception {
        if(Boolean.TRUE.equals(isYes)){
            return getNodeByID(current.getYesNode().getId());
        }
            return getNodeByID(current.getNoNode().getId());
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
