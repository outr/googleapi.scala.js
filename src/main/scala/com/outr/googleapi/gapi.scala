package com.outr.googleapi

import scala.scalajs.js
import scala.scalajs.js.Promise
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("gapi")
object gapi extends js.Object {
  def load(library: String, onSuccess: js.Function0[Unit]): Unit = js.native
  def auth2: Auth2 = js.native
}

trait Auth2 extends js.Object {
  def init(options: Options): Promise[Unit]

  def getAuthInstance(): GoogleAuth
}

trait Options extends js.Object {
  var clientId: js.UndefOr[String] = js.undefined
  var cookiePolicy: js.UndefOr[String] = js.undefined
  var scope: js.UndefOr[String] = js.undefined
  var fetchBasicProfile: js.UndefOr[Boolean] = js.undefined
  var hostedDomain: js.UndefOr[String] = js.undefined
  var openidRealm: js.UndefOr[String] = js.undefined
  var uxMode: js.UndefOr[String] = js.undefined
  var redirectUri: js.UndefOr[String] = js.undefined
}

trait GoogleAuth extends js.Object {
  def isSignedIn: IsSignedIn
  def signIn(options: js.UndefOr[SignInOptions] = js.undefined): js.Promise[GoogleUser]
  def signOut(): js.Promise[Unit]
  def disconnect(): Unit
  def grantOfflineAccess(options: js.UndefOr[GrantOfflineAccessOptions] = js.undefined): js.Promise[Authorization]
  def currentUser: CurrentUser
}

trait SignInOptions extends js.Object {
  var appPackageName: js.UndefOr[String] = js.undefined
  var prompt: js.UndefOr[String] = js.undefined
  var scope: js.UndefOr[String] = js.undefined
  var uxMode: js.UndefOr[String] = js.undefined
  var redirectUri: js.UndefOr[String] = js.undefined
}

trait IsSignedIn extends js.Object {
  def get(): Boolean
  def listen(listener: js.Function1[Boolean, Unit]): Unit
}

trait CurrentUser extends js.Object {
  def get(): GoogleUser
  def listen(listener: js.Function1[GoogleUser, Unit]): Unit
}

trait GoogleUser extends js.Object {
  def getId(): String
  def isSignedIn(): Boolean
  def getHostedDomain(): String
  def getGrantedScopes(): String
  def getBasicProfile(): BasicProfile
}

trait GrantOfflineAccessOptions extends js.Object {
  var appPackageName: js.UndefOr[String] = js.undefined
  var prompt: js.UndefOr[String] = js.undefined
  var scope: js.UndefOr[String] = js.undefined
}

trait Authorization extends js.Object {
  def code: String
}

trait BasicProfile extends js.Object {
  def getId(): String
  def getName(): String
  def getGivenName(): String
  def getFamilyName(): String
  def getImageUrl(): String
  def getEmail(): String
}