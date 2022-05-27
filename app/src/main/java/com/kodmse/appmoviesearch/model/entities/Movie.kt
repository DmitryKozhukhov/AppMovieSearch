package com.kodmse.appmoviesearch.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val image: Int = 0,
    val name: String = "Москва слезам не верит",
    val country: String = "Россия",
    val year: Int = 1980,
    val rating: Double = 8.4
) : Parcelable

fun getAllMovies() = listOf(
    Movie(1, "Фильм1", "Страна1", 2000, 8.0),
    Movie(2, "Фильм2", "Страна2", 2001, 8.1),
    Movie(3, "Фильм3", "Страна3", 2002, 8.2),
    Movie(4, "Фильм4", "Страна4", 2003, 8.3),
    Movie(5, "Фильм5", "Страна5", 2004, 8.4),
    Movie(6, "Фильм6", "Страна6", 2005, 8.5),
    Movie(7, "Фильм7", "Страна7", 2006, 8.6),
    Movie(8, "Фильм8", "Страна8", 2007, 8.7),
    Movie(9, "Фильм9", "Страна9", 2008, 8.8),
    Movie(10, "Фильм10", "Страна10", 2009, 8.9)
)

fun getTopMovies() = listOf(
    Movie(11, "Фильм11", "Страна11", 2010, 9.0),
    Movie(12, "Фильм12", "Страна12", 2011, 9.1),
    Movie(13, "Фильм13", "Страна13", 2012, 9.2),
    Movie(14, "Фильм14", "Страна14", 2013, 9.3),
    Movie(15, "Фильм15", "Страна15", 2014, 9.4),
    Movie(16, "Фильм16", "Страна16", 2015, 9.5),
    Movie(17, "Фильм17", "Страна17", 2016, 9.6),
    Movie(18, "Фильм18", "Страна18", 2017, 9.7),
    Movie(19, "Фильм19", "Страна19", 2018, 9.8),
    Movie(20, "Фильм20", "Страна20", 2019, 9.9)
)

