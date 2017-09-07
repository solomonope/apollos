package org.appollos.exposure

import org.appollos.core.Image

object Inverse {

  def apply(im: Image): Image = {
    val rt = Image(im.width, im.height);
    for (i <- 0 until im.height) {
      for (j <- 0 until im.width) {
        val v = 255.0 - im(j, i).asInstanceOf[Double]
        rt(j, i, v);
      }
    }
    return rt;

  }
}
