package com.example.darfe.constraintanim

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import com.example.darfe.constraintanim.databinding.ActivityMainExpandedBinding
import com.example.darfe.constraintanim.models.Movie
import kotlinx.android.synthetic.main.activity_main_expanded.*

class MainActivity : AppCompatActivity() {

    val setExpanded:ConstraintSet = ConstraintSet()
    val setCollapsed:ConstraintSet = ConstraintSet()

    var expanded:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainExpandedBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_main_expanded)



        setExpanded.clone(root)
        setCollapsed.clone(this, R.layout.activity_main)

        val movie = Movie("Acuaman",
            "https://img.elcomercio.pe/files/article_content_ec_fotos/uploads/2018/12/11/5c1017702c38e.jpeg",
            "12 de Diciembre",
            "2 horas",
            "La mejor Pelicula")

        binding.movie = movie

        btnInfo.setOnClickListener{
            TransitionManager.beginDelayedTransition(root)
            if(expanded) setCollapsed.applyTo(root)
            else setExpanded.applyTo(root)
            expanded = !expanded
        }

    }
}
