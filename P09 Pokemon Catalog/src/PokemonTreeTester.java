
//////////////// P09 Pokemon Catalog //////////////////////////
//
// Title: PokemonTreeTester
// Course: CS 300 Fall 2020
//
// Author: Jerry Yu
// Email: jcyu4@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PokemonTree.
 *
 */

public class PokemonTreeTester {

  /**
   * Checks the correctness of the implementation of both addPokemon() and toString() methods
   * implemented in the PokemonTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PokemonTree, and check that its size is 0, it is empty, and
   * that its string representation is an empty string "". (2) try adding one Pokemon and then check
   * that the addPokemon() method call returns true, the tree is not empty, its size is 1, and the
   * .toString() called on the tree returns the expected output. (3) Try adding another Pokemon
   * which is more powerful than the one at the root, (4) Try adding a third Pokemon which is less
   * powerful than the one at the root, (5) Try adding at least two further Pokemons such that one
   * must be added at the left subtree, and the other at the right subtree. For all the above
   * scenarios, and more, double check each time that size() method returns the expected value, the
   * add method call returns true, and that the .toString() method returns the expected string
   * representation of the contents of the binary search tree in an ascendant order from the most
   * powerful Pokemon to the least powerful one. (6) Try adding a Pokemon whose CP value was used as
   * a key for a Pokemon already stored in the tree. Make sure that the addPokemon() method call
   * returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPokemonToStringSize() {
    try {
      // Scenario 1: Create a new empty PokemonTree and check that it is empty
      PokemonTree bst = new PokemonTree();
      if (bst.size() != 0 || bst.isEmpty() != true || !(bst.toString().equals(""))) {
        return false;
      }
      // Scenario 2: Adding one pokemon to the tree
      String expected1 = new String("[Charmander CP:321 (A:3 S:2 D:1)]\n");
      if (bst.addPokemon(new Pokemon("Charmander", "3,2,1")) != true || bst.isEmpty() != false
          || bst.size() != 1 || !(bst.toString().equals(expected1))) {
        return false;
      }
      // Scenario 3: Adding another pokemon that is more powerful than the one at the root
      String expected2 =
          new String("[Charmander CP:321 (A:3 S:2 D:1)]\n[Snorlax CP:448 (A:4 S:4 D:8)]\n");
      if (bst.addPokemon(new Pokemon("Snorlax", "4,4,8")) != true || bst.isEmpty() != false
          || bst.size() != 2 || !(bst.toString().equals(expected2))) {
        return false;
      }
      // Scenario 4: Adding another pokemon that is less powerful than the one at the root
      String expected3 =
          new String("[Pikachu CP:123 (A:1 S:2 D:3)]\n[Charmander CP:321 (A:3 S:2 D:1)]\n"
              + "[Snorlax CP:448 (A:4 S:4 D:8)]\n");
      if (bst.addPokemon(new Pokemon("Pikachu", "1,2,3")) != true || bst.isEmpty() != false
          || bst.size() != 3 || !(bst.toString().equals(expected3))) {
        return false;
      }
      // Scenario 5: Adding two more pokemon, one into the left subtree and one into the right
      String expected4 = new String("[Pikachu CP:123 (A:1 S:2 D:3)]\n[Eevee CP:224 (A:2 S:2 D:4)]\n"
          + "[Charmander CP:321 (A:3 S:2 D:1)]\n[Snorlax CP:448 (A:4 S:4 D:8)]\n"
          + "[Mewtwo CP:999 (A:9 S:9 D:9)]\n");
      if (bst.addPokemon(new Pokemon("Mewtwo", "9,9,9")) != true
          || bst.addPokemon(new Pokemon("Eevee", "2,2,4")) != true || bst.isEmpty() != false
          || bst.size() != 5 || !(bst.toString().equals(expected4))) {
        return false;
      }
      // Scenario 6: Adding a pokemon whose CP has already been added
      if (bst.addPokemon(new Pokemon("Groudon", "9,9,9")) != false || bst.size() != 5) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * This method checks mainly for the correctness of the PokemonTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new PokemonTree. Then, check that
   * calling the lookup() method with any valid CP value must throw a NoSuchElementException. (2)
   * Consider a PokemonTree of height 3 which consists of at least 5 PokemonNodes. Then, try to call
   * lookup() method to search for the Pokemon at the root of the tree, then a Pokemon at the right
   * and left subtrees at different levels. Make sure that the lookup() method returns the expected
   * output for every method call. (3) Consider calling .lookup() method on a non-empty PokemonTree
   * with a CP value not stored in the tree, and ensure that the method call throws a
   * NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPokemonAndLookup() {
    try {
      // Scenario 1: Create a new PokemonTree and call the lookup() method
      PokemonTree bst = new PokemonTree();
      try {
        bst.lookup(123);
        return false;

      } catch (NoSuchElementException ne) {
        // Expected exception to be thrown
      }
      // Scenario 2: Consider a PokemonTree of height 3 which consists of at least 5 PokemonNodes
      Pokemon snorlax = new Pokemon("Snorlax", "4,4,8");
      Pokemon eevee = new Pokemon("Eevee", "2,2,4");
      Pokemon mewtwo = new Pokemon("Mewtwo", "9,9,9");
      Pokemon bulbasaur = new Pokemon("Bulbasaur", "2,2,3");
      Pokemon rayquaza = new Pokemon("Rayquaza", "8,2,3");
      bst.addPokemon(snorlax);
      bst.addPokemon(eevee);
      bst.addPokemon(mewtwo);
      bst.addPokemon(bulbasaur);
      bst.addPokemon(rayquaza);
      if (bst.lookup(448) != snorlax && bst.lookup(224) != eevee && bst.lookup(823) != rayquaza) {
        return false;
      }
      // Scenario 3: Call lookup() with a cp not stored in the tree
      try {
        bst.lookup(555);
        return false;
      } catch (NoSuchElementException ne) {
        // Expected exception to be thrown
      }
    } catch (Exception e) {
      System.out.println("Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of PokemonTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty Pokemon tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a PokemonTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*)(*) (*)
   * / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    try {
      PokemonTree bst = new PokemonTree();
      // Scenario 1: Call height() on an empty Pokemon tree
      if (bst.height() != 0) {
        return false;
      }
      // Scenario 2: Call height() on a Pokemon tree with only one node
      Pokemon snorlax = new Pokemon("Snorlax", "4,4,8");
      bst.addPokemon(snorlax);
      if (bst.height() != 1) {
        return false;
      }
      // Scenario 3: Call height() on a Pokemon tree with many nodes
      Pokemon eevee = new Pokemon("Eevee", "2,2,4");
      Pokemon mewtwo = new Pokemon("Mewtwo", "9,9,9");
      Pokemon bulbasaur = new Pokemon("Bulbasaur", "2,2,3");
      Pokemon rayquaza = new Pokemon("Rayquaza", "8,2,3");
      Pokemon pikachu = new Pokemon("Pikachu", "1,2,3");
      bst.addPokemon(eevee);
      bst.addPokemon(mewtwo);
      bst.addPokemon(bulbasaur);
      bst.addPokemon(rayquaza);
      bst.addPokemon(pikachu);
      if (bst.height() != 4) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of PokemonTree.getLeastPowerfulPokemon() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetLeastPowerfulPokemon() {
    try {
      // Scenario 1: Call getLeastPowerfulPokemon() on non-empty BST
      PokemonTree bst = new PokemonTree();
      if (bst.getLeastPowerfulPokemon() != null) {
        return false;
      }
      // Scenario 2: Call getLeastPowerfulPokemon() on non-empty BST
      Pokemon eevee = new Pokemon("Eevee", "2,2,4");
      Pokemon mewtwo = new Pokemon("Mewtwo", "9,9,9");
      Pokemon bulbasaur = new Pokemon("Bulbasaur", "2,2,3");
      Pokemon rayquaza = new Pokemon("Rayquaza", "8,2,3");
      Pokemon pikachu = new Pokemon("Pikachu", "1,2,3");
      bst.addPokemon(eevee);
      bst.addPokemon(mewtwo);
      bst.addPokemon(bulbasaur);
      bst.addPokemon(rayquaza);
      bst.addPokemon(pikachu);
      if (bst.getLeastPowerfulPokemon() != pikachu) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of PokemonTree.getMostPowerfulPokemon() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetMostPowerfulPokemon() {
    try {
      // Scenario 1: Call getMostPowerfulPokemon() on non-empty BST
      PokemonTree bst = new PokemonTree();
      if (bst.getMostPowerfulPokemon() != null) {
        return false;
      }
      // Scenario 2: Call getMostPowerfulPokemon() on non-empty BST
      Pokemon eevee = new Pokemon("Eevee", "2,2,4");
      Pokemon mewtwo = new Pokemon("Mewtwo", "9,9,9");
      Pokemon bulbasaur = new Pokemon("Bulbasaur", "2,2,3");
      Pokemon rayquaza = new Pokemon("Rayquaza", "8,2,3");
      Pokemon pikachu = new Pokemon("Pikachu", "1,2,3");
      bst.addPokemon(eevee);
      bst.addPokemon(mewtwo);
      bst.addPokemon(bulbasaur);
      bst.addPokemon(rayquaza);
      bst.addPokemon(pikachu);
      if (bst.getMostPowerfulPokemon() != mewtwo) {
        return false;
      }
    } catch (Exception e) {
      System.out.println("Unknown exception was thrown");
      return false;
    }
    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(testAddPokemonToStringSize());
    System.out.println(testAddPokemonAndLookup());
    System.out.println(testHeight());
    System.out.println(testGetLeastPowerfulPokemon());
    System.out.println(testGetMostPowerfulPokemon());
  }

}
