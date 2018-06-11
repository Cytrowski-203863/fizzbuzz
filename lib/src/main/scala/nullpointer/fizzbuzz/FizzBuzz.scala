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
  def getToken(number: Int): Token =
    if (number % 3 == 0 && number % 5 == 0)
      FizzBuzzToken()
    else if (number % 3 == 0)
      FizzToken()
    else if (number % 5 == 0)
      BuzzToken()
    else
      NumberToken(number)
}
