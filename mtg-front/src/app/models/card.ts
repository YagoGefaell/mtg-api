export interface Card {
    id: string;
    name: string;
    mana_cost: string;
    type_line: string;
    rarity: string;
    image_uris: {[key: string]: string};
}
