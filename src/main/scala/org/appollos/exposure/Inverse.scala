package org.appollos.exposure

import org.appollos.core.Image

import scala.reflect.ClassTag;

object Inverse {

  def apply[T: ClassTag](im: Image[T]): Image[T] = {
    val rt = Image[T](im.width, im.height);
    for (i <- 0 until im.height) {
      for (j <- 0 until im.width) {
        val v = 255.0 - im(j, i).asInstanceOf[Double]
        rt(j, i, v.asInstanceOf[T]);
      }
    }
    return rt;

  }
}
