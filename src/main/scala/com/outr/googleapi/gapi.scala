package com.outr.googleapi

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("gapi")
object gapi extends js.Object {
  def load(library: String, onSuccess: js.Function0[Unit]): Unit = js.native
  def auth2: Auth2 = js.native
  def client: Client = js.native
}