package packt.core

import scala.collection.mutable

object FunctionalBasics {

  def main(args: Array[String]): Unit = {

        val tokens = List[String]("Settlements", "some", "centuries", "old", "and", "still", "no", "bigger", "than",
          "pinheads", "on", "the", "untouched", "expanse", "of", "their", "background")

        ////////////////////////////////////////////
        // map
        ////////////////////////////////////////////
        // anonymous functions, all are equivalent:

        val lengthAnonymous1 = tokens.map(token => token.length) // parameter explicitly mentioned
        val lengthAnonymous2 = tokens.map((token: String) => token.length) // parameter with type
        val lengthAnonymous3 = tokens.map(_.length) // single param. can be replaced by wildcard _
        val lengthAnonymous4 = tokens map { token => token.length }
        val lengthAnonymous5 = tokens map { (token: String) => token.length }

        // Result: List(11, 4, 9, 3, 3, 5, 2, 6, 4, 8, 2, 3, 9, 7, 2, 5, 10)

        println(lengthAnonymous1)
        println(lengthAnonymous2)
        println(lengthAnonymous3)
        println(lengthAnonymous4)
        println(lengthAnonymous5)

        // non anonymous:
        def lengthMethod(token: String): Int = token.length // method argument is a String, return type an integer
        val lengthFunction: (String => Int) = token => token.length // function type is a function mapping a String to an integer
        val tokenLengths1 = tokens.map(lengthFunction)


        // declare len as a function that takes a String and returns an Int, and define it as returning the length of its argument
        val len: String => Int = { _.length }

        // or, a more verbose version that uses '=>' in both ways
        val len: String => Int = { (s: String) => s.length }
    
        val tokenLengths = tokens.map(lengthFunction)

        ////////////////////////////////////////////
        // flatMap
        ////////////////////////////////////////////
        def lowerLengthMethod(token: String): Option[Int] = {
          if (token.charAt(0).isUpper) // skip elements starting with uppercase letter
            None
          else // else return the length of the lowercase token
            Some(token.length)
        }

        val lowerTokenLengths = tokens.flatMap(lowerLengthMethod)

        ////////////////////////////////////////////
        // reduce
        ////////////////////////////////////////////
        def minLengthMethod(tokenLengths: (Int, Int)): Int = {
          if (tokenLengths._1 <= tokenLengths._2)
            tokenLengths._1
          else
            tokenLengths._2
        }

        val minLength: Int = tokens
          .map(lengthFunction)
          .reduce((length1: Int, length2: Int) => minLengthMethod(length1, length2)) // or shorter:  .reduce(minLengthMethod(_,_))

        ////////////////////////////////////////////
        // foldLeft
        ////////////////////////////////////////////

        def addInitialToSet(set: mutable.Set[String], nextToken: String): mutable.Set[String] = {
          set.add(nextToken.substring(0, 1))
          set
        }

        val distinctInitials = tokens
          .foldLeft(mutable.Set.empty[String])((accumulator: mutable.Set[String], nextToken: String) => addInitialToSet(accumulator, nextToken))
        // or shorter:  .foldLeft(mutable.Set.empty[String])(addInitialToSet)

  }
}
