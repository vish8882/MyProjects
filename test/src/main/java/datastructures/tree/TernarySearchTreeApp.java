package datastructures.tree;

class TernarySearchTree {

  private Node root;

  public void insertWord(String s) {
    Node prev = null;
    Node current = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      while (true) {
        if (current == null) {
          if (current == root) {
            root = new Node(c, i == s.length() - 1);
            prev = root;
            current = root.middle;
          } else {
            current = new Node(c, i == s.length() - 1);
            prev.middle = current;
            prev = current;
            current = current.middle;
          }
          break;
        } else {
          if (c == current.value) {
            prev = current;
            current = current.middle;
            break;
          } else if (c < current.value) {
            if (current.left == null) {
              current.left = new Node(c, i == s.length() - 1);
              prev = current.left;
              current = prev.middle;
              break;
            } else {
              current = current.left;
              continue;
            }
          } else if (c > current.value) {
            if (current.right == null) {
              current.right = new Node(c, i == s.length() - 1);
              prev = current.right;
              current = prev.middle;
              break;
            } else {
              current = current.right;
              continue;
            }
          }
        }
      }
    }
    System.out.println("Inserted word : " + s);
  }

  public void printAllWords() {
    iterateTree(root, "");
  }

  private void iterateTree(Node node, String s) {
    if (node != null) {
      iterateTree(node.left, s);
      if (node.isAWord) {
        System.out.println(s+ node.value);
      }
      iterateTree(node.middle, s + node.value);

      iterateTree(node.right, s);
    }
    return;
  }

  public boolean searchWord(String s) {
    String word = "";
    Node curr = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      while (true) {
        if (curr == null) {
          System.out.println("Word does not exist : " + s);
          return false;
        }
        if (c == curr.value) {
          word = word + c;
          curr = curr.middle;
          break;
        } else if (c < curr.value) {
          curr = curr.left;
        } else if (c > curr.value) {
          curr = curr.right;
        }
      }
    }
    System.out.println("Found word : " + word);
    return true;
  }

  static class Node {

    Node left;
    Node middle;
    Node right;
    char value;
    boolean isAWord;

    public Node(char value, boolean isAWord) {
      this.value = value;
      this.isAWord = isAWord;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getMiddle() {
      return middle;
    }

    public void setMiddle(Node middle) {
      this.middle = middle;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }

  }
}

public class TernarySearchTreeApp {

  public static void main(String[] args) {
    TernarySearchTree tst = new TernarySearchTree();
    System.out.println("---------********* Inserting words *********---------");
    tst.insertWord("geek");
    tst.insertWord("cat");
    tst.insertWord("geeks");
    tst.insertWord("geekify");
    tst.insertWord("cap");
    tst.insertWord("app");
    System.out.println();
    System.out.println("---------********* Searching words *********---------");
    tst.searchWord("geekify");
    tst.searchWord("cap");
    tst.searchWord("cas");
    tst.searchWord("app");
    System.out.println();
    System.out.println("---------********* Print all words *********---------");
    tst.printAllWords();
  }
}
