export interface ScryfallList<T> {
    object: string;
    total_cards: number;
    has_more: boolean;
    next_page: string;
    data: T[];
}
