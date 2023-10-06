sealed trait Command {
  def execute(): Direction
}

case class RotateLeftCommand(direction: Direction) extends Command {
  override def execute(): Direction = direction.atLeft()
}

case class RotateRightCommand(direction: Direction) extends Command {
  override def execute(): Direction = direction.atRight()
}
