package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Person class.
 */
public class Person implements Comparable<Person> {
    int key;
    String name;

    /**
     * Person stuff.
     * @param NUID number
     * @param name the name
     */
    Person(int NUID, String name) {
        this.key = NUID;
        this.name = name;
    }

    /**
     * the to string.
     */
    public String toString() {
        return "NUID: " + this.key + "  Name: " + name;
    }

    /**
     * compare to.
     */
    public int compareTo(Person other) {
        return Integer.compare(key, other.key);
    }
}
