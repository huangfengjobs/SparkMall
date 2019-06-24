package com.atguigu.sparkmall.common.util

/**
  * @author Huangfeng
  * @create 2019-06-19 下午 1:52
  */
object StringUtil {

  def isNotEmpty(s:String): Boolean ={
    s!=null && !"".equals(s.trim)
  }

}
