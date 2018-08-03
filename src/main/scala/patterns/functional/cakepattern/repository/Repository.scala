package patterns.functional.cakepattern.repository

trait Repository[Entity, UUID] {
  def save(entity: Entity): UUID
  def findById(id: UUID): Option[Entity]
}
