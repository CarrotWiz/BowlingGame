package app.bowlinggame.model

data class User(
    var uid: String? = null,
    var email: String? = null,
    var userName: String? = null,
    var highScore: Int = 0,
    var bowlingAvg: Int = 0,
    var Games: List<Game> = emptyList(),
)