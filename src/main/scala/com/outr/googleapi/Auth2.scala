package com.outr.googleapi

import scala.scalajs.js
import scala.scalajs.js.Promise

trait Auth2 extends js.Object {
  def init(options: Auth2Options): Promise[Unit]

  def getAuthInstance(): GoogleAuth
}