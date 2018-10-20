# Test.scala

```scala
package test

import com.outr.googleapi.{ClientOptions, GoogleAPI, gapi}

import scala.scalajs.js.annotation.JSExportTopLevel
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalajs.dom._
import profig.Profig

import scala.scalajs.js

object Test {
  @JSExportTopLevel("application")
  def main(): Unit = {
    Profig.loadDefaults()

    println("Hello, World!")
    val key = Profig("apiKey").as[String]
    val cid = Profig("clientId").as[String]
//    val api = new GoogleAPI(clientId)

    gapi.load("client:auth2", () => {
      println("gapi.load - success")
      gapi.client.init(new ClientOptions {
        apiKey = key
        discoveryDocs = js.Array("https://people.googleapis.com/$discovery/rest?version=v1")
        clientId = cid
        scope = "https://mail.google.com/"
      }).toFuture.foreach { _ =>
        println("gapi.client.init - success")
      }
    })

    addButton("Test") {
      gapi.auth2.getAuthInstance().signIn().toFuture.foreach { user =>
        println("gapi.auth2.getAuthInstance().signIn() - success!")
        println(s"User: ${user.getBasicProfile().getEmail()}, Token: ${user.getAuthResponse().id_token}")
      }
    }

//    def addSignOut(): Unit = {
      addButton("Sign Out") {
        gapi.auth2.getAuthInstance().disconnect()
//        gapi.auth2.getAuthInstance().signOut().toFuture.foreach { _ =>
//          println("Signed out!")
//        }
      }
//    }
//
//    api.user().foreach {
//      case Some(user) => {
//        println(s"Already Signed in: ${user.getBasicProfile().getName()} / ${user.getBasicProfile().getEmail()} / ${user.getBasicProfile().getImageUrl()}")
//        addSignOut()
//      }
//      case None => addButton("Sign In") {
//        api.signIn().foreach { user =>
//          println(s"Signed in: ${user.getBasicProfile().getName()} / ${user.getBasicProfile().getEmail()} / ${user.getBasicProfile().getImageUrl()}")
//          addSignOut()
//        }
//      }
//    }
  }

  def addButton(label: String)(action: => Unit): Unit = {
    val button = document.createElement("button")
    button.innerHTML = label
    button.addEventListener("click", (event: Event) => {
      event.stopPropagation()
      event.preventDefault()

      action
    })
    document.body.appendChild(button)
  }
}
```