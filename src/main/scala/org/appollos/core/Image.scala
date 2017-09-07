package org.appollos.core

import breeze.linalg.DenseMatrix
import org.appollos.core.ImageType.ImageType


object Image {

  def apply(channels: Int, imageType: ImageType, width: Int, height: Int): Image = new Image(channels, imageType, width, height);

  def apply(width: Int, height: Int): Image = new Image(1, ImageType.EIGHT_BPC, width, height);

  def apply(): Image = null;
}

class Image(private val channels: Int, val imageType: ImageType, val width: Int, val height: Int) {

  private val data: Array[DenseMatrix[Double]] = new Array[DenseMatrix[Double]](channels);
  for (ch: Int <- 0 until channels) {
    this.data(ch) = new DenseMatrix[Double](this.height, this.width);
  }

  private def putPixel(channel: Int, x: Int, y: Int, value: Double): Unit = {
    data(channel)(y, x) = value;
  }

  private def getPixel(channel: Int, x: Int, y: Int): Double = {
    data(channel)(y, x);
  }

  def apply(channel: Int, x: Int, y: Int, value: Double): Unit = {
    putPixel(channel, x, y, value);
  }

  def apply(channel: Int, x: Int, y: Int): Double = {
    return getPixel(channel, x, y);
  }

  def apply(x: Int, y: Int, value: Double): Unit = {
    this.apply(0, x, y, value)
  }

  def apply(x: Int, y: Int): Double = {
    return this.apply(0, x, y);
  }

  def apply(channel: Int): DenseMatrix[Double] = {
    return this.data(channel);
  }

}

object ImageType extends Enumeration {
  type ImageType = Value;
  val EIGHT_BPC = Value(8);
  val SIXTEEN_BPC = Value(16);
}
