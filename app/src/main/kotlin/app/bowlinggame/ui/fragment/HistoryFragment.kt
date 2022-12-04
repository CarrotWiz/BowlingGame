package app.bowlinggame.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import app.bowlinggame.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HistoryFragment : Fragment(){
    private lateinit var averageScore: TextView
    private lateinit var bestScore: TextView
    private lateinit var gamesPlayed: TextView

    lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.history_fragment, container, false)
        averageScore = v.findViewById(R.id.average_score)
        bestScore = v.findViewById(R.id.best_score)
        gamesPlayed = v.findViewById(R.id.games_played)

        auth = FirebaseAuth.getInstance()
        database = Firebase.database.reference

        auth.currentUser?.let { getHistory(it.uid) }

        return v
    }

    private fun getHistory(userId: String){
        database.child("Users").child(userId).get().addOnSuccessListener {
            val user = it
            if(it.hasChild("games")) {
                setFields(
                    it.child("bowlingAvg"),
                    it.child("highScore"),
                    it.child("games").childrenCount
                )
            } else {
                setFields(0, 0, 0)
            }
        }.addOnFailureListener{
            print("failed to load user data for $userId")
        }
    }

    private fun setFields(averageScore: DataSnapshot, bestScore: DataSnapshot, gamesPlayed: Long) {
        val averageScoreText = "Average Score: $averageScore"
        val bestScoreText = "Best Score: $bestScore"
        val gamesPlayedText = "Games Played: $gamesPlayed"
        this.averageScore.text = averageScoreText
        this.bestScore.text = bestScoreText
        this.gamesPlayed.text = gamesPlayedText
    }

    private fun setFields(averageScore: Int, bestScore: Int, gamesPlayed: Int) {
        val averageScoreText = "Average Score: $averageScore"
        val bestScoreText = "Best Score: $bestScore"
        val gamesPlayedText = "Games Played: $gamesPlayed"
        this.averageScore.text = averageScoreText
        this.bestScore.text = bestScoreText
        this.gamesPlayed.text = gamesPlayedText
    }
}