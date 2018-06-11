package nullpointer.fizzbuzz

import nullpointer.fizzbuzz.FizzBuzz.{BuzzToken, FizzBuzzToken, FizzToken, Token}

object FizzBuzz {
  sealed trait Token
  case class FizzToken() extends Token
  case class BuzzToken() extends Token
  case class FizzBuzzToken() extends Token
}

class FizzBuzz {
  def getToken(number: Int): Option[Token] =
    if (number % 3 == 0 && number % 5 == 0)
      Some(FizzBuzzToken())
    else if (number % 3 == 0)
      Some(FizzToken())
    else if (number % 5 == 0)
      Some(BuzzToken())
    else
      None
}
