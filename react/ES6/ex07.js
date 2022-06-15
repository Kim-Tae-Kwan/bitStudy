class Cl01{
    constructor(a){
        this.su1 = a;
        console.log('Cl01 constructor')
    }
    get(){return this.su1};
    set(su){this.su1 = su}
}

class Cl02 extends Cl01{
    constructor(b){
        super(b);
        this.su2 = b;
        console.log('Cl02 constructor')
    }
    get(){return this.su2};
    set(su){this.su2 = su}
}

let obj = new Cl02();
obj.set(4000);
console.log(obj.get());

