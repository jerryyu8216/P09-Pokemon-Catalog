//////////////// P09 Pokemon Catalog //////////////////////////
//
// Title: PokemonNode
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
/**
 * This class acts as a node that stores pokemon and acts as part of a binary search tree.
 *
 */
public class PokemonNode {
  private Pokemon data; // The pokemon this node is storing
  private PokemonNode leftChild; // The leftChild of this node
  private PokemonNode rightChild; // The rightChild of this node

  /**
   * The constructor of the PokemonNode that initializes all instance fields
   * 
   * @param data
   */
  public PokemonNode(Pokemon data) {
    if (data == null) {
      throw new IllegalArgumentException();
    } else {
      this.data = data;
      this.leftChild = null;
      this.rightChild = null;
    }
  }

  /**
   * A public getter method that returns the leftChild of the current node
   * 
   * @return the PokemonNode stored in leftChild
   */
  public PokemonNode getLeftChild() {
    return leftChild;
  }

  /**
   * A public getter method that returns the rightChild of the current node
   * 
   * @return the PokemonNode stored in rightChild
   */
  public PokemonNode getRightChild() {
    return rightChild;
  }

  /**
   * A public getter method that returns the pokemon stored in the current node
   * 
   * @return the pokemon stored in data
   */
  public Pokemon getPokemon() {
    return data;
  }

  /**
   * A public setter method that initializes leftChild
   * 
   */
  public void setLeftChild(PokemonNode left) {
    this.leftChild = left;
  }

  /**
   * A public setter method that initializes rightChild
   * 
   */
  public void setRightChild(PokemonNode right) {
    this.rightChild = right;
  }
}
