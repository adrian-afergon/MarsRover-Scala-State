sealed trait Direction {
  def atRight(): Direction

  def atLeft(): Direction
}

case class North() extends Direction {
  override def atLeft(): Direction = West()

  override def atRight(): Direction = East()
}

case class West() extends Direction {
  override def atLeft(): Direction = South()

  override def atRight(): Direction = North()
}

case class East() extends Direction {
  override def atLeft(): Direction = North()

  override def atRight(): Direction = South()
}

case class South() extends Direction {
  override def atLeft(): Direction = East()

  override def atRight(): Direction = West()
}