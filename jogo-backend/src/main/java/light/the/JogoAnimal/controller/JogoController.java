package light.the.JogoAnimal.controller;

import light.the.JogoAnimal.domain.Node;
import light.the.JogoAnimal.service.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class JogoController {

    private final NodeService nodeService;

    @GetMapping
    public ResponseEntity<Node> getRootNode(){
        return ResponseEntity.ok(nodeService.getRootNode());
    }

    @GetMapping("{id}/yes")
    public ResponseEntity<Node> getNext(@PathVariable("id") Long id){
        return ResponseEntity.ok(nodeService.getNext(id, true));
    }
    @GetMapping("{id}/no")
    public ResponseEntity<Node> getNextFalse(@PathVariable("id") Long id){
        return ResponseEntity.ok(nodeService.getNext(id, false));
    }

    @PostMapping("new")
    public ResponseEntity<Node> createNode(@RequestBody Node newNode){
        return ResponseEntity.created(URI.create("api/nodes")).body(newNode); // TODO: criar o node e refinar ideia
    }


}
