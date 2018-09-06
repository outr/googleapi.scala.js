package com.outr.googleapi

import scala.scalajs.js

trait CurrentUser extends js.Object {
  def get(): GoogleUser
  def listen(listener: js.Function1[GoogleUser, Unit]): Unit
}
