package nullpointer.fizzbuzz

import nullpointer.fizzbuzz.FizzBuzz.{BuzzToken, FizzBuzzToken, FizzToken, NumberToken}
import org.scalatest.FlatSpec

class FizzBuzzSpec extends FlatSpec {
  private lazy val BASE_NUMBERS = 1 to 1000
  private lazy val DIVISIBLE_BY_3_NUMBERS = BASE_NUMBERS.filter(_ % 3 == 0)
  private lazy val DIVISIBLE_BY_5_NUMBERS = BASE_NUMBERS.filter(_ % 5 == 0)
  private lazy val FIZZ_NUMBERS = DIVISIBLE_BY_3_NUMBERS.diff(DIVISIBLE_BY_5_NUMBERS)
  private lazy val BUZZ_NUMBERS = DIVISIBLE_BY_5_NUMBERS.diff(DIVISIBLE_BY_3_NUMBERS)
  private lazy val FIZZBUZZ_NUMBERS = DIVISIBLE_BY_3_NUMBERS.intersect(DIVISIBLE_BY_5_NUMBERS)
  private lazy val OTHER_NUMBERS = BASE_NUMBERS.diff(DIVISIBLE_BY_3_NUMBERS).diff(DIVISIBLE_BY_5_NUMBERS)
  private lazy val fizzBuzz = new FizzBuzz

  it should "return FizzToken on number divisible by 3" in {
    FIZZ_NUMBERS.foreach { i =>
      val token = fizzBuzz.getToken(i)
      assert(token.isInstanceOf[FizzToken])
    }
  }

  it should "return BuzzToken on number divisible by 5" in {
    BUZZ_NUMBERS.foreach { i =>
      val token = fizzBuzz.getToken(i)
      assert(token.isInstanceOf[BuzzToken])
    }
  }

  it should "return FizzBuzzToken on number divisible by 3 and by 5" in {
    FIZZBUZZ_NUMBERS.foreach { i =>
      val token = fizzBuzz.getToken(i)
      assert(token.isInstanceOf[FizzBuzzToken])
    }
  }

  it should "return NumberToken on number not divisible by 3 and by 5" in {
    OTHER_NUMBERS.foreach { i =>
      val token = fizzBuzz.getToken(i)
      assert(token.isInstanceOf[NumberToken])
    }
  }

  it should "return NumberToken with correct value on number not divisible by 3 and by 5" in {
    OTHER_NUMBERS.foreach { i =>
      val token = fizzBuzz.getToken(i).asInstanceOf[NumberToken]
      assert(token.value === i)
    }
  }
}
