package com.jshvarts.githubkmp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jshvarts.Greeting
import com.jshvarts.api.UpdateProblem
import com.jshvarts.model.Member
import com.jshvarts.presentation.MemberPresenter
import com.jshvarts.presentation.MembersView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MembersView {

    private val repository by lazy { (application as GithubKMPApplication).dataRepository }
    private val presenter by lazy { MemberPresenter(this, repository) }

    private lateinit var adapter: MemberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greeting.text = Greeting().greeting()

        setupRecyclerVIew()

        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override var isUpdating = false // not go ing to be used

    override fun onUpdate(members: List<Member>) {
        adapter.members = members

        runOnUiThread {
           adapter.notifyDataSetChanged()
        }
    }

    override fun showError(error: Throwable) {
        val errorMessage = when (error) {
            is UpdateProblem -> getString(R.string.update_problem)
            else -> getString(R.string.unknown_error)
        }

        runOnUiThread {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerVIew() {
        membersRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MemberAdapter(emptyList())
        membersRecyclerView.adapter = adapter
    }
}
