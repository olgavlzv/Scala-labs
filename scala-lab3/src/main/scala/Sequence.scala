/** Напишите свои решения в тестовых функциях.
 *
 * Seq(1, 2) match {
 *   case head +: tail => ???
 *   case Nil          => ???
 *   case s            => ???
 * }
 *
 * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
 */

object Sequence extends App {

  // a) Найдите последний элемент Seq.
  def testLastElement[A](seq: Seq[A]): Option[A] = seq.lastOption
  println(testLastElement(Seq(5, 15, 6, 16, 7)))

  // b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.
  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = a zip b
  println(testZip(Seq(0, 1, 2), Seq(2, 1, 0)))

  // c) Проверьте, выполняется ли условие для всех элементов в Seq.
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = seq.forall(cond)
  println(testForAll(Seq(2, 4, 8, 12))(x => x % 2 == 0))

  // d) Проверьте, является ли Seq палиндромом
  def testPalindrom[A](seq: Seq[A]): Boolean = seq == seq.reverse
  println(testPalindrom(Seq(1, 2, 3, 2, 1)))

  // e) Реализуйте flatMap используя foldLeft.
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = seq.foldLeft(Seq[B]())((x, y) => x++:f(y))
  println(testFlatMap(Seq(12, 8, 4))(x => Seq(x / 4)))
}