package com.outr.googleapi

import scala.scalajs.js

trait BasicProfile extends js.Object {
  def getId(): String
  def getName(): String
  def getGivenName(): String
  def getFamilyName(): String
  def getImageUrl(): String
  def getEmail(): String
}
