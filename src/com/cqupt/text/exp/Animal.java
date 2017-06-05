package com.cqupt.text.exp;

/**
 * @author weigs
 * @date 2017/6/5 0005
 */
class Animal {
    public void make_speak() {
        System.out.print("\n Hello, I am a " + species_name + "."
                + "\n I have eaten: ");
        for (int i = 0; i < numberOfFeedings; i++) {
            System.out.print(stomach_contents[i] + " ");
        }
    }

    public void feed(String food_for_this_animal) {

        stomach_contents[numberOfFeedings++] = food_for_this_animal;
    }

    public Animal(Animal another_animal) {
        species_name = another_animal.species_name;
        stomach_contents = another_animal.stomach_contents;
    }

    public Animal(String given_species_name) {
        species_name = given_species_name;
    }

    String species_name;
    String[] stomach_contents = new String[30];
    int numberOfFeedings = 0;
}

class AnimalsReverseOrder {
    public static void main(String[] not_in_use) {
        Animal cat_object = new Animal("cat");
        Animal dog_object = new Animal("vegetarian dog");

        cat_object.feed("fish");
        cat_object.feed("chicken");

        dog_object.feed("salad");
        dog_object.feed("potatoes");

        Animal another_cat = new Animal(cat_object);

        another_cat.feed("milk");

        cat_object.make_speak();
        dog_object.make_speak();
        another_cat.make_speak();

        Carnivore carnivore = new Carnivore("lion");
        carnivore.feed(dog_object);
        carnivore.make_speak();

    }
}

class Carnivore extends Animal{
    public Carnivore(String given_species_name) {
        super(given_species_name);
    }

    public void feed(Animal animal) {
        stomach_contents[numberOfFeedings++] = animal.species_name;
    }
}

