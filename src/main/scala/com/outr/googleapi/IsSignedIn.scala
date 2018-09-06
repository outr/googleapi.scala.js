package com.outr.googleapi

import scala.scalajs.js

trait IsSignedIn extends js.Object {
  def get(): Boolean
  def listen(listener: js.Function1[Boolean, Unit]): Unit
}
