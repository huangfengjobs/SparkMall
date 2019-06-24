package com.atguigu.sparkmall.common.util

import java.io.InputStream
import java.util.{Properties, ResourceBundle}

import com.alibaba.fastjson.{JSON, JSONObject}

/**
  * @author Huangfeng
  * @create 2019-06-18 下午 3:09
  */
object ConfigUtil {

  private val bundle: ResourceBundle = ResourceBundle.getBundle("config")
  private val resourceBundle: ResourceBundle = ResourceBundle.getBundle("condition")

  /**
    * 根据条件获取数据
    * @param cond
    * @return
    */
  def getValueFromCondition(cond:String): String ={
    val conds: String = resourceBundle.getString("condition.params.json")
    val json: JSONObject = JSON.parseObject(conds)
    json.getString(cond)
  }

  /**
    * 专门从配置文件获取配置信息的代码
    * @param key
    * @return
    */
  def getValueFromConfig(key:String) :String={
    bundle.getString(key)
  }

  /**
    * 从配置文件中获取配置信息
    * @param key
    * @return
    */
  def getValue(key :String): String ={
    val stream: InputStream = Thread.currentThread().getContextClassLoader.getResourceAsStream("config.properties")

    val properties = new Properties()
    properties.load(stream)

    properties.getProperty(key)
  }

}
