
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks



class MarsRoverTest extends AnyFunSpec with TableDrivenPropertyChecks with should.Matchers{
  describe("Mars Rover") {
    it("should be landed facing given specific direction") {
      val marsRover = MarsRover.land(North())

      marsRover.direction should be(North())
    }

    describe("should face") {
      Table(
        ("label", "initialDirection", "command", "expectedDirection"),
        ("West when starting North and turning Left", North(), Action("L"), West()),
        ("East when starting North and turning Right", North(), Action("R"), East()),
        ("North when starting East and turning Left", East(), Action("L"), North()),
        ("South when starting East and turning Right", East(), Action("R"), South()),
        ("East when starting South and turning Left", South(), Action("L"), East()),
        ("West when starting South and turning Right", South(), Action("R"), West()),
        ("South when starting West and turning Left", West(), Action("L"), South()),
        ("North when starting West and turning Right", West(), Action("R"), North())
      ).foreach { case (label, initialDirection, command, expectedDirection) =>
        it(s"$label") {
          val marsRover = MarsRover.land(initialDirection)
          marsRover.execute(command)
          marsRover.direction should be(expectedDirection)
        }
      }
    }

    it("should be able to interpret multiple instructions per action") {
      val marsRover = MarsRover.land(North())

      marsRover.execute(Action("LLLR"))

      marsRover.direction should be(South())
    }
  }
}
