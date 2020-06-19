/*
 *  Copyright 2018, The Android Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example.android.marsrealestate.detail

import android.app.Application
import androidx.lifecycle.*
import com.example.android.marsrealestate.network.MarsProperty
import com.example.android.marsrealestate.R
/**
 * The [ViewModel] that is associated with the [DetailFragment].
 */
class DetailViewModel(marsProperty: MarsProperty, app: Application) : AndroidViewModel(app) {
    val _selectedProperty=MutableLiveData<MarsProperty>()
    val selectedProperty:LiveData<MarsProperty> get() = _selectedProperty

    val displayPrice=Transformations.map(selectedProperty){
        app.resources.getString(when(it.isRental){
            true->R.string.display_price_monthly_rental
            false->R.string.display_price
        },it.price)

    }

    val displayType=Transformations.map(selectedProperty){
        app.resources.getString(R.string.display_type,it.type)
    }

    init {
        _selectedProperty.value=marsProperty
    }




}
