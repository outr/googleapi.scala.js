package com.outr.googleapi

import scala.scalajs.js

trait ClientOptions extends js.Object {
  var apiKey: js.UndefOr[String] = js.undefined
  var discoveryDocs: js.UndefOr[js.Array[String]] = js.undefined
  var clientId: js.UndefOr[String] = js.undefined
  var scope: js.UndefOr[String] = js.undefined
}
