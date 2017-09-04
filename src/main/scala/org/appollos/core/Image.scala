package org.appollos.core

import breeze.linalg.DenseMatrix

import scala.reflect.ClassTag;

object Image {

  def apply[T: ClassTag](channels: Int, width: Int, height: Int): Image[T] = new Image[T](channels, width, height);

  def apply[T: ClassTag](width: Int, height: Int): Image[T] = new Image[T](1, width, height);

  def apply[T: ClassTag](): Image[T] = null;
}

class Image[T: ClassTag](private val channels: Int, val width: Int, val height: Int) {

  private val data: Array[DenseMatrix[T]] = new Array[DenseMatrix[T]](channels);
  for (ch: Int <- 0 until channels) {
    this.data(ch) = new DenseMatrix[T](this.height, this.width);
  }

  private def putPixel(channel: Int, x: Int, y: Int, value: T): Unit = {
    data(channel)(y, x) = value;
  }

  private def getPixel(channel: Int, x: Int, y: Int): T = {
    data(channel)(y, x);
  }

  def apply(channel: Int, x: Int, y: Int, value: T): Unit = {
    putPixel(channel, x, y, value);
  }

  def apply(channel: Int, x: Int, y: Int): T = {
    return getPixel(channel, x, y);
  }

  def apply(x: Int, y: Int, value: T): Unit = {
    this.apply(0, x, y, value)
  }

  def apply(x: Int, y: Int): T = {
    return this.apply(0, x, y);
  }

  def apply(channel: Int): DenseMatrix[T] = {
    return this.data(channel);
  }

}
