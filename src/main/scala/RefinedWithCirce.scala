import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Positive
import eu.timepit.refined.string.StartsWith
import io.circe.parser._
import io.circe.generic.auto._
import io.circe.refined._ //Refinedの型に対応

object RefinedWithCirce extends App {
  val notPositiveJson =
    """
      |{
      |  "positive": -1,
      |  "startWithHoge": "startWithHoge"
      |}
    """.stripMargin

  println("decode[Datum](notPositiveJson) = " + decode[Datum](notPositiveJson))

  val validJson =
    """
      |{
      |  "positive": 2,
      |  "startWithHoge" : "hogehoge"
      |}
    """.stripMargin

  println("decode[Datum](validJson) = " + decode[Datum](validJson))
}


case class Datum(positive: Int Refined Positive, startWithHoge: String Refined StartsWith[W.`"hoge"`.T])
