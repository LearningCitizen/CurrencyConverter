export class Currency {
    name: string = "cur";
    trigram: string = "CUR";
    exchangeRate: number = 1.0;

    public Currency(name :string, trigram: string, exchangeRate: number){
        this.name = name;
        this.trigram = trigram;
        this.exchangeRate = exchangeRate;
    }
}
