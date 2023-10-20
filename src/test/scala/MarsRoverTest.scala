
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks

class MarsRoverTest extends AnyFunSpec with TableDrivenPropertyChecks with should.Matchers {
  describe("Mars Rover") {
    it("should be landed facing given specific orientation and location") {
      val marsRover = MarsRover.land(North(), Position(0, 0))

      marsRover.orientation should be(North())
      marsRover.position should be(Position(0, 0))
    }

    it("should rotate given directions") {
      val marsRover = MarsRover.land(North(), Position(0, 0))

      marsRover.execute(Command("LLLR"))

      marsRover.orientation should be(South())
    }
  }
}
