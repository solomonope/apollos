package org.appollos.io

import org.appollos.core.Image


object ImageIO {

  def read(filePath: String): Image = {
    return new Image(1, 1, 1);
  }

  def write(filePath: String, image: Image): Unit = {

  }
}
