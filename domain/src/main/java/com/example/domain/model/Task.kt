package com.example.domain.model

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
data class Task(
    val id :Int,
    val title:String,
    val isDone : Boolean
): DomainModel()