
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks

class MarsRoverTest extends AnyFunSpec with TableDrivenPropertyChecks with should.Matchers {
  describe("Mars Rover") {
    it("should be landed facing given specific orientation") {
      val marsRover = MarsRover.land(North())

      marsRover.orientation should be(North())
    }

    it("should rotate given directions") {
      val marsRover = MarsRover.land(North())

      marsRover.execute(Command("LLLR"))

      marsRover.orientation should be(South())
    }
  }
}
