import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.collection._
import eu.timepit.refined.numeric._
import eu.timepit.refined.string._

object SimpleExample{

  //正の値
  val positive: Int Refined Positive = 10

  // コンパイルエラー
  // val positive :Int Refined Positive = -1

  //2.5より小さい
  val `lessThan2.5`: Double Refined Less[W.`2.5`.T] = 1.8

  //1から3まで
  val inTheRange: Int Refined Interval.Closed[W.`1`.T, W.`3`.T] = 2

  //必ず一つ以上の要素を含む
  type NonEmptyCollection = Seq[String] Refined NonEmpty

  val strings = List("hoge", "fuga", "tom")
  val nonEmpty: Either[String, NonEmptyCollection] = refineV(strings)

  //正の数値を含む
  type ContainsPositive = Seq[Int] Refined Exists[Positive]

  val numbers = List(1, 3 ,5)
  val containsPositive: Either[String, ContainsPositive] = refineV(numbers) // Right

  //文字列"hoge"から始まる
  val startsWithHoge: String Refined StartsWith[W.`"hoge"`.T] = "hogefuga"

  //パターンにマッチする
  val matched: String Refined MatchesRegex[W.`"[a-z]0[A-Z]+"`.T] = "a0AHFOEHF"

  // コンパイルエラー
  //val matched: String Refined MatchesRegex[W.`"[a-z]0[A-Z]+"`.T] = "abcde"

  val url: String Refined Url = "http://example.com"

  val regex: String Refined Regex = "[a-z]0[A-Z]+"
}
