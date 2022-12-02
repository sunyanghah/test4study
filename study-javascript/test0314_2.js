const materials = [
    'Hydrogen',
    'Helium',
    'Lithium',
    'Beryllium'
];

console.log(materials.map(material => material.length));


/**
 * 在箭头函数出现之前，每一个新函数根据它是被如何调用的来定义这个函数的this值：

 如果该函数是一个构造函数，this指针指向一个新的对象
 在严格模式下的函数调用下，this指向undefined
 如果该函数是一个对象的方法，则它的this指针指向这个对象
 等等
 * @constructor
 */
function Person() {
    // Person() 构造函数定义 `this`作为它自己的实例.
    this.age = 0;

    setInterval(function growUp() {
        // 在非严格模式, growUp()函数定义 `this`作为全局对象,
        // 与在 Person()构造函数中定义的 `this`并不相同.
        this.age++;
    }, 1000);
}

var p = new Person();

setInterval(function growUp() {
    console.log("p--------"+p.age)
}, 500);

/**
 * 在ECMAScript 3/5中，通过将this值分配给封闭的变量，可以解决this问题。
 * @constructor
 */
function Person2() {
    var that = this;
    that.age = 0;

    setInterval(function growUp() {
        // 回调引用的是`that`变量, 其值是预期的对象.
        that.age++;
    }, 1000);
}

var p2 = new Person2();
setInterval(function growUp() {
    console.log("p2--------"+p2.age)
}, 500);

/**
 * 箭头函数不会创建自己的this,它只会从自己的作用域链的上一层继承this。因此，在下面的代码中，传递给setInterval的函数内的this与封闭函数中的this值相同：
 * @constructor
 */
function Person3(){
    this.age = 0;

    setInterval(() => {
        this.age++; // |this| 正确地指向 p 实例
    }, 1000);
}

var p3 = new Person3();
setInterval(function growUp() {
    console.log("p3--------"+p3.age)
}, 500);


/**
 * 由于 箭头函数没有自己的this指针，通过 call() 或 apply() 方法调用一个函数时，只能传递参数（不能绑定this---译者注），
 * 他们的第一个参数会被忽略。（这种现象对于bind方法同样成立---译者注）
 * @type {{add: (function(*=): *), addThruCall: (function(*=): *), base: number}}
 */
var adder = {
    base : 1,

    add : function(a) {
        var f = v => v + this.base;
        return f(a);
    },

    addThruCall: function(a) {
        var f = v => v + this.base;
        var b = {
            base : 2
        };

        return f.call(b, a);
    }
};

console.log(adder.add(1));         // 输出 2
console.log(adder.addThruCall(1)); // 仍然输出 2
