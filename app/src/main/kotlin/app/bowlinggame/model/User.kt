package app.bowlinggame.model

data class User(
    var uid: String? = null,
    var email: String? = null,
    var username: String? = null,
    var highScore: Int = 0,
    var bowlingAvg: Int = 0,
)