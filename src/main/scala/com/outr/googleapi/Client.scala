package com.outr.googleapi

import scala.scalajs.js
import scala.scalajs.js.Promise

trait Client extends js.Object {
  def init(options: ClientOptions): Promise[Unit]
}
