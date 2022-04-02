package com.example.rickandmorty2.base

interface BaseDiffModel {

    val id: Int
    override fun equals(other: Any?): Boolean
}