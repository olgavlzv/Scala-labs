/** Напишите вашу реализацию в тестовые функции.
 *
 * https://docs.scala-lang.org/overviews/collections/maps.html
 */
object Maps extends App {
  case class User(name: String, age: Int)

  val charactersList: Seq[User] = Seq(User("Ben", 14), User("Ada", 23), User("Jon", 19), User("Dan", 25))

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и вычислите средний возраст: `name -> averageAge`
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testGroupUsers(users: Seq[User]): Map[String, Int] = users.groupBy(_.name).map(row => (row._1, row._2.head.age)) + ("averageAge" -> users.map(_.age).sum / users.length)
  println(testGroupUsers(charactersList))

  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  val imposterMap = Map("1" -> User("Adam", 25), "2" -> User("Adam", 30), "3" -> User("Adamantis", 35), "4" -> User("JoshDun", 40))
  def testNumberFrodos(map: Map[String, User]): Int = map.map(x => x._2.name).count(x => x.contains("Adam"))
  println(testNumberFrodos(imposterMap))

  /* c) Удалите всех пользователей возраст которых менее 35 лет.
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testUnderaged(map: Map[String, User]): Map[String, User] = map.filter(x => x._2.age >= 35)
  println(testUnderaged(imposterMap))
}
