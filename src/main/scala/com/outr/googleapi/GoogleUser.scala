package com.outr.googleapi

import scala.scalajs.js

trait GoogleUser extends js.Object {
  def getId(): String
  def isSignedIn(): Boolean
  def getHostedDomain(): String
  def getGrantedScopes(): String
  def getBasicProfile(): BasicProfile
}
