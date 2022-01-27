package light.the.JogoAnimal.domain;

import light.the.JogoAnimal.utils.EnumNodeType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="node")
public class Node implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "type")
    EnumNodeType type;

    @Column(name = "description")
    String description;

    @OneToOne
    @JoinColumn(name = "yes_id", referencedColumnName = "id")
    Node yesNode;

    @OneToOne
    @JoinColumn(name = "no_id", referencedColumnName = "id")
    Node noNode;
}
