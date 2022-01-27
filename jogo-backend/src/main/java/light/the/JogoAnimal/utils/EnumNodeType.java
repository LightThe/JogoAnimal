package light.the.JogoAnimal.utils;

import java.io.Serializable;

public enum EnumNodeType implements Serializable {
    REGRA("Regra"),
    ANIMAL("Animal");

    private String descricao;

    EnumNodeType(String desc) { this.descricao = desc; }

    public String getDescricao() {
        return descricao;
    }
}
