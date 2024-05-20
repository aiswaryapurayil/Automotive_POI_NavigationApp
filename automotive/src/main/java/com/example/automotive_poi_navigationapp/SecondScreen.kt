package com.example.automotive_poi_navigationapp

import android.graphics.Color
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.ActionStrip
import androidx.car.app.model.CarColor
import androidx.car.app.model.CarIcon
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import data.PlaceRepository
import data.model.Place
import data.model.toIntent

class SecondScreen(carContext: CarContext, val placeId: Int) : Screen(carContext) {
    private var isFavorite=false
    override fun onGetTemplate(): Template {
        val place=PlaceRepository().getPlace(placeId)?: return MessageTemplate.Builder("Place not found").
        setHeaderAction(Action.BACK).build()

        val navigateAction=Action.Builder()
            .setTitle("Navigate")
            .setOnClickListener{carContext.startCarApp(place.toIntent(CarContext.ACTION_NAVIGATE))}.build()

        val actionStrip= ActionStrip.Builder()
            .addAction(
                Action.Builder()
                    .setIcon(
                        CarIcon.Builder(
                            IconCompat.createWithResource(
                                carContext,
                                R.drawable.baseline_favorite_24
                            )
                            ).setTint(
                                if (isFavorite) CarColor.RED else CarColor.createCustom(
                                    Color.LTGRAY,
                                    Color.DKGRAY
                                )
                            ).build()
                        ).setOnClickListener {
                            isFavorite=!isFavorite
                        invalidate()
                        //Request that 'onGetTemplate' be called again so that updates to the screen's state can be picked up
                        //setting variable value
                    }.build()
            ).build()

        return PaneTemplate.Builder(
            Pane.Builder().addAction(navigateAction)
                .addRow(
                    Row.Builder()
                    .setTitle("Coordinates")
                    .addText("${place.latitude},${place.longitude}")
                    .build()
                 )
                .addRow(
                    Row.Builder()
                        .setTitle("Description")
                        .addText(place.description)
                        .build()
                ).build()
        ).setTitle(place.name)
            .setHeaderAction(Action.BACK)
            .setActionStrip(actionStrip)
            .build()


    }

}
