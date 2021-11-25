import scala.runtime.Nothing$

abstract class MySndList{
  //add, head, tail, isEmpty, printElement, toString
  // filter, flatmap, concat
  def add(element:Int):MySndList
  def head:Int
  def tail:MySndList
  def isEmpty:Boolean
  def printElement:String
}

object EmptySnd extends MySndList {
  def add(element:Int):ConsSnd = new ConsSnd(element,EmptySnd)
  def head:Int = throw new NoSuchElementException
  def tail:MySndList = throw new NoSuchElementException
  def isEmpty:Boolean = true
  override def printElement: String = ""
}
class ConsSnd(h:Int,t:ConsSnd) extends MySndList{
  override def add(element: Int): ConsSnd= new ConsSnd(element,this)
  override def head: Int = h
  override def tail: MySndList = t
  override def isEmpty: Boolean = false
  override def printElement: String = {
    s"$h" + " " + s"${t.printElement}"
  }
}


object MySndListExcercise extends App{
  val listOfIntegers= new ConsSnd(1,new ConsSnd(2,new ConsSnd(3,EmptySnd)))

}


