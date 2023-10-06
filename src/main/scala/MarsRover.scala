class MarsRover (initialDirection: Direction) {
  var direction: Direction = initialDirection

  def execute(command: Command): Unit = rotateBasedOn(command)

  private def rotateBasedOn(command: Command): Unit = {
    direction = command.instructions match {
      case "L" => direction.atLeft()
      case "R" => direction.atRight()
    }
  }
}

object MarsRover {
  def land(direction: Direction) = new MarsRover(direction)

}