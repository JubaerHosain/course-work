package com.company;



//The engine and car relationship are implemented using Java classes as below.
// In Java, the ‘final’ keyword is used to represent Composition. This is because the ‘Owner’ object
// expects a part object to be available and function by making it ‘final’.

class Car {
    private final Engine engine;

    public Car() {
        engine  = new Engine();
    }

}

class Engine {
    private String type;
}

public class Composition {

}



//restricted form of the Aggregation where the entities are strongly dependent on each other.
// Unlike Aggregation, Composition represents the part-of relationship. When there is an aggregation
// between two entities, the aggregate object can exist without the other entity, but in the case of Composition,
// the composed object can't exist.

//The composition relationship of two objects is possible when one object contains another object,
// and that object is fully dependent on it.

//The Composition represents a part-of(More than Has-A?) relationship.
//It represents part-of relationship.
//In composition, both entities are dependent on each other.
//When there is a composition between two entities, the composed object cannot exist without the other entity.

// For example, A ‘Human’ class is a composition of Heart and lungs. When the human object dies,
// nobody parts exist.