package com.example.automotive_poi_navigationapp

import android.text.Spannable
import android.text.SpannableString
import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.CarLocation
import androidx.car.app.model.Distance
import androidx.car.app.model.DistanceSpan
import androidx.car.app.model.ItemList
import androidx.car.app.model.Metadata
import androidx.car.app.model.Place
import androidx.car.app.model.PlaceListMapTemplate
import androidx.car.app.model.PlaceMarker
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import data.PlaceRepository


class FirstScreen(carContext: CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template {
        val placesRepository = PlaceRepository()

        val itemListBuilder = ItemList.Builder().setNoItemsMessage("No places found")
//val places = placesRepository.getPlaces()

        placesRepository.getPlaces().forEach{
            itemListBuilder.addItem(
                Row.Builder()
                    .setTitle(it.name)
                    .addText(SpannableString(" ").apply {
                        setSpan(
                            DistanceSpan.create(
                                Distance.create(Math.random()*100, Distance.UNIT_KILOMETERS)),
                            0,1,
                            Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    })
                    .setOnClickListener {
                        screenManager.push(SecondScreen(carContext,it.id))
                    }

                    .setMetadata(
                        Metadata.Builder()
                            .setPlace(
                                Place.Builder(CarLocation.create(it.latitude,it.longitude))
                                    .setMarker(PlaceMarker.Builder().build())
                                    .build()
                            ).build()

                    )
                    .build()
            )
        }

        return PlaceListMapTemplate.Builder()
            .setTitle("Famous Malls")
            .setItemList(itemListBuilder.build())
            .build()
    }

}