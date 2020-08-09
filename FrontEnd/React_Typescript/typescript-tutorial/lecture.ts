interface obj<T extends string | number> {
    add: (a: T, b: T) => T;
}

const a: obj<number> = {
    add: (a, b) => {
        return a + b;
    },
};

const b: obj<string> = {
    add: (a, b) => {
        return a + b;
    },
};

function forEach<T>(arr: T[], callback: (item: T) => void): void {
    for (let i: number = 0; i < arr.length; i++) {
        callback(arr[i]);
    }
}

forEach<string>(['a', 'b', 'c'], (item) => {});

interface Card {
    att: number;
    hp: number;
    mine: boolean;
    field: boolean;
    cost?: number;
    hero?: boolean;
}

class Hero implements Card {
    att: number;
    hp: number;
    mine: boolean;
    field: boolean;
    hero: boolean;
    constructor(mine: boolean) {
        this.mine = mine;
        this.att = Math.ceil(Math.random() * 2);
        this.hp = Math.ceil(Math.random() * 5) + 25;
        this.hero = true;
        this.field = true;
    }
}

class Sub implements Card {
    att: number;
    hp: number;
    mine: boolean;
    field: boolean = false;
    cost: number;
    constructor(mine: boolean) {
        this.mine = mine;
        this.att = Math.ceil(Math.random() * 5);
        this.hp = Math.ceil(Math.random() * 5);
        this.cost = Math.floor((this.att + this.hp) / 2);
    }
}

interface Player {
    hero: HTMLDivElement;
    deck: HTMLDivElement;
    field: HTMLDivElement;
    cost: HTMLDivElement;
    deckData: Card[];
    heroData?: Card | null;
    fieldData: Card[];
    chosenCard?: HTMLDivElement | null;
    chosenCardData?: Card | null;
}

const opponent: Player = {
    hero: document.getElementById('rival-hero') as HTMLDivElement,
    deck: document.getElementById('rival-deck') as HTMLDivElement,
    field: document.getElementById('rival-cards') as HTMLDivElement,
    cost: document.getElementById('rival-cost') as HTMLDivElement,
    deckData: [],
    heroData: null,
    fieldData: [],
    chosenCard: null,
    chosenCardData: null,
};

const me: Player = {
    hero: document.getElementById('my-hero') as HTMLDivElement,
    deck: document.getElementById('my-deck') as HTMLDivElement,
    field: document.getElementById('my-cards') as HTMLDivElement,
    cost: document.getElementById('my-cost') as HTMLDivElement,
    deckData: [],
    heroData: null,
    fieldData: [],
    chosenCard: null,
    chosenCardData: null,
};
