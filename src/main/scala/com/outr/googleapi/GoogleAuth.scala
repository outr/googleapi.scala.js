package com.outr.googleapi

import scala.scalajs.js

trait GoogleAuth extends js.Object {
  def isSignedIn: IsSignedIn
  def signIn(options: js.UndefOr[SignInOptions] = js.undefined): js.Promise[GoogleUser]
  def signOut(): js.Promise[Unit]
  def disconnect(): Unit
  def grantOfflineAccess(options: js.UndefOr[GrantOfflineAccessOptions] = js.undefined): js.Promise[Authorization]
  def currentUser: CurrentUser
}