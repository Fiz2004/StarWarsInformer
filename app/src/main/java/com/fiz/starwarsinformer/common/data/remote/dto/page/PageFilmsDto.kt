package com.fiz.starwarsinformer.common.data.remote.dto.page

import com.fiz.starwarsinformer.common.data.remote.dto.one.FilmDto
import com.google.gson.annotations.SerializedName

data class PageFilmsDto(
    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<FilmDto?>?,
)