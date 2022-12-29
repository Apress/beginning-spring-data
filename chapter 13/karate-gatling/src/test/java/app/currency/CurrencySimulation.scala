package app.currency

import com.intuit.karate.Runner
import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._

import scala.concurrent.duration._

class CurrencySimulation extends Simulation {

  def urlPattern = "GET /api/catalog/currency/1"

  val protocol = karateProtocol(
    "/currency/{id}" -> Nil
  )

  protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")

  //Which is the environment to run the test
  protocol.runner.karateEnv("dev")

  //The name of the file and the scenario to run
  val get = scenario("Get all the information about one currency").exec(karateFeature("classpath:app/currency/get-currency.feature"))

  setUp(
    //The number of users that receive the endpoint for a period of time
    get.inject(rampUsers(10) during (5 seconds)).protocols(protocol)
  ).assertions(
    //The conditions that you want to validate
    details(urlPattern).responseTime.percentile3.lte(3000)
  )

}