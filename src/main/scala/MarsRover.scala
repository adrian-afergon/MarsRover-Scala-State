class MarsRover (initialOrientation: Orientation) {
  var orientation: Orientation = initialOrientation

  def execute(command: Command): Unit = rotateBasedOn(command)

  private def rotateBasedOn(command: Command): Unit = {
    command.instructions.foreach { instruction =>
      orientation = instruction match {
        case 'L' => orientation.atLeft()
        case 'R' => orientation.atRight()
      }
    }
  }
}

object MarsRover {
  def land(orientation: Orientation) = new MarsRover(orientation)
}