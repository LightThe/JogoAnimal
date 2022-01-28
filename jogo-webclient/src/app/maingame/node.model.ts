export enum NodeType{
    Regra = 'REGRA',
    Animal = 'ANIMAL'
}

export class NodeModel{
    public id?: number;
    public type: NodeType;
    public description: string;
    public yesNode: NodeModel;
    public noNode: NodeModel;

    public buildNode(type: NodeType, description: string, yesNode: NodeModel, noNode: NodeModel){
        this.type = type;
        this.description = description;
        this.yesNode = yesNode;
        this.noNode = noNode;
    }
}
