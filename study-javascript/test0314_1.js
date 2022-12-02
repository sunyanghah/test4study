class Rectangle {

    // 公有字段
    girth;
    // 私有字段
    #girth2;

    // constructor
    constructor(height, width) {
        this.height = height;
        this.width = width;
        this.girth = (height+width)*2;
        this.#girth2 = (height+width)*2;
    }
    // Getter
    get area() {
        return this.calcArea()
    }
    // Method
    calcArea() {
        return this.height * this.width;
    }
}
const square = new Rectangle(20, 10);

console.log(square.area);
console.log(square.height);
console.log(square.girth);
// console.log(square.#girth2)
