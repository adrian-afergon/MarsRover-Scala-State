import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should

class MarsRoverTest extends AnyFunSpec with should.Matchers{

  describe("Mars Rover") {
    it("should be landed facing given specific direction") {
      val marsRover = MarsRover.land(North())

      marsRover.direction should be(North())
    }

    it("should face the expected direction given specific command") {
      val marsRover = MarsRover.land(North())
      val command = Command("L")

      marsRover.execute(command)

      marsRover.direction should be(West())
    }
  }

}
