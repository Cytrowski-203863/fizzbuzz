package nullpointer.fizzbuzz

import nullpointer.fizzbuzz.FizzBuzz.{BuzzToken, FizzBuzzToken, FizzToken}

object Application extends App {
  val fizzBuzz = new FizzBuzz
  for (i <- 1 to 100) {
    val tokenOption = fizzBuzz.getToken(i)
    println(tokenOption match {
      case Some(token) =>
        token match {
          case FizzToken() => "Fizz"
          case BuzzToken() => "Buzz"
          case FizzBuzzToken() => "FizzBuzz"
        }
      case None => i
    })
  }
}
