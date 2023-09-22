sealed trait Direction {
  def atLeft(): Direction
}

case class North() extends Direction {
  override def atLeft(): Direction = West()
}

case class West() extends Direction {
  override def atLeft(): Direction = ???
}