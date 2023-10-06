class MarsRover (initialDirection: Direction) {
  var command: Command = _
  var direction: Direction = initialDirection

  def execute(action: Action): Unit = rotateBasedOn(action)

  private def rotateBasedOn(action: Action): Unit = {
    action.instructions.foreach { instruction =>
      direction = instruction match {
        case 'L' =>
          var rotateLeftCommand = RotateLeftCommand(direction)
          command = rotateLeftCommand
          command.execute()
        case 'R' =>
          var rotateRightCommand = RotateRightCommand(direction)
          command = rotateRightCommand
          command.execute()
      }
    }
  }
}

object MarsRover {
  def land(direction: Direction) = new MarsRover(direction)

}