package nullpointer.fizzbuzz

import nullpointer.fizzbuzz.FizzBuzz._

object FizzBuzz {
  sealed trait Token
  case class FizzToken() extends Token
  case class BuzzToken() extends Token
  case class FizzBuzzToken() extends Token
  case class NumberToken(value: Int) extends Token
}

class FizzBuzz {
  def getToken(number: Int): Token = {
    val divisibleBy3 = isDivisibleBy3(number)
    val divisibleBy5 = isDivisibleBy5(number)
    if (divisibleBy3 && divisibleBy5)
      FizzBuzzToken()
    else if (divisibleBy3)
      FizzToken()
    else if (divisibleBy5)
      BuzzToken()
    else
      NumberToken(number)
  }

  private def isDivisibleBy3(number: Int): Boolean =
    number % 3 == 0

  private def isDivisibleBy5(number: Int): Boolean =
    number % 5 == 0
}
