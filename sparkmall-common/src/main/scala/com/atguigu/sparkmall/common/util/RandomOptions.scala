package com.atguigu.sparkmall.common.util

import java.util.Random
import scala.collection.mutable.ListBuffer

/**
  * @author Huangfeng
  * @create 2019-06-18 下午 3:58
  */
object RandomOptions {

  def apply[T](opts: RanOpt[T]*): RandomOptions[T] = {
    val randomOptions = new RandomOptions[T]()
    for (opt <- opts) {
      randomOptions.totalWeight += opt.weight
      for (i <- 1 to opt.weight) {
        randomOptions.optsBuffer += opt.value
      }
    }
    randomOptions
  }


  def main(args: Array[String]): Unit = {
    val randomName = RandomOptions(RanOpt("zhangchen", 10), RanOpt("li4", 30))
    for (i <- 1 to 40) {
      println(i + ":" + randomName.getRandomOpt())

    }
  }


}


case class RanOpt[T](value: T, weight: Int) {
}

class RandomOptions[T](opts: RanOpt[T]*) {
  var totalWeight = 0
  var optsBuffer = new ListBuffer[T]

  def getRandomOpt(): T = {
    val randomNum = new Random().nextInt(totalWeight)
    optsBuffer(randomNum)
  }

}
