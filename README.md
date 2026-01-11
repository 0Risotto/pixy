# Pixy

A Java implementation of the Lox programming language interpreter, crafted with care from the book **"Crafting Interpreters"** by Robert Nystrom. Pixy is a tree-walk interpreter that brings the Lox language to life with elegance and clarity.

![Lox Language](https://img.shields.io/badge/Language-Lox-ff69b4)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![License](https://img.shields.io/badge/License-MIT-blue)
![File Extension](https://img.shields.io/badge/Extension-.pixy-blueviolet)

##  Features

**Complete Lox Language Support:**
- ✅ Variables, scoping, and closures
- ✅ Control flow (if/else, while, for, logical operators)
- ✅ Functions with return values and recursion
- ✅ Classes, inheritance, and `this` keyword
- ✅ Native functions (`clock()`, input/output)

**Developer Experience:**
-  Interactive REPL for rapid experimentation
-  Detailed error reporting with line numbers
-  Simple mark-and-sweep garbage collector
-  Clear AST representation and debugging
-  Native `.pixy` file extension support

##  Quick Start

### Installation
```bash
# Clone the repository
git clone https://github.com/0Risotto/pixy.git
cd pixy

# Build with Maven
mvn clean package
```

### Usage
**Interactive Mode:**
```bash
java -jar target/pixy.jar
```
```javascript
Pixy> fun greet(name) { print "Hello, " + name; }
Pixy> greet("Lox Developer");
Hello, Lox Developer
```

**Run a `.Pixy` Script:**
```bash
java -jar target/pixy.jar examples/fibonacci.Pixy
```

**Run multiple `.Pixy` files:**
```bash
java -jar target/pixy.jar program1.Pixy program2.Pixy program3.Pixy
```

##  Examples

### Hello World (`hello.Pixy`)
```javascript
print "Hello from Pixy!";
print "Welcome to the world of .pixy files!";

fun welcome() {
    var message = "This is a .pixy file in action!";

    print message;
}

welcome();
```

### Fibonacci Sequence (`fibonacci.Pixy`)
```javascript
fun fib(n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}

for (var i = 0; i < 20; i = i + 1) {
    print "fib(" + i + ") = " + fib(i);
}
```

### Classes and Objects (`breakfast.Pixy`)
```javascript
class Breakfast {
    init(meat, bread) {
        this.meat = meat;
        this.bread = bread;
    }
    
    serve(who) {
        print "Enjoy your " + this.meat + " and " + this.bread + ", " + who + ".";
    }
}

var meal = Breakfast("bacon", "toast");
meal.serve("Pixy Developer");  
```

##  Architecture

```
     Source Code (.pixy)
         ↓
      Scanner        (Lexical Analysis → Tokens)
         ↓
      Parser         (Syntax Analysis → AST)
         ↓
     Resolver        (Semantic Analysis → Scopes)
         ↓
   Interpreter       (Tree-walk Execution)
         ↓
    Output/Runtime
```

**Key Components:**
- `Scanner.java`: Tokenizes `.pixy` source code
- `Parser.java`: Builds Abstract Syntax Tree using recursive descent
- `Resolver.java`: Variable resolution and semantic checking
- `Interpreter.java`: Tree-walk execution engine
- `Environment.java`: Manages scopes and closures
- `pixy.java`: Main entry point with `.pixy` file handling


## License
Distributed under the MIT License. See `LICENSE` for more information.

